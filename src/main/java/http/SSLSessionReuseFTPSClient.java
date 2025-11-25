package http;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;

import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.Util;

/*
使用FTPSClient连接FTP下载文件，连接和登录都没有问题，
但是下载文件时方法ftpsClient.listNames却报错：522 SSL connection failed; session reuse required: see require_ssl_reuse option in vsftpd.conf man page。
原来是FTP的require_ssl_reuse=YES导致的， 当选项require_ssl_reuse设置为YES时，所有SSL数据连接都需要显示SSL会话重用;
证明他们知道与控制信道相同的主秘钥。联系客户把这个参数设置成NO之后果然可以下载了。
如果设置为YES就没办法了吗，当然有办法，那就是使用SSL通道重用。
但FTPSClient目前是不支持ssl通道重用的，So，不要在浪费时间了。
不过可以重写FTPSClient达到目的。重写代码如下：
 */
public class SSLSessionReuseFTPSClient extends FTPSClient {



    /**
     * @param command the command to get
     * @param remote  the remote file name
     * @param local   the local file name
     * @return true if successful
     * @throws IOException on error
     * @since 3.1
     */
    @Override
    protected boolean _retrieveFile(String command, String remote, OutputStream local) throws IOException {
        Socket socket = _openDataConnection_(command, remote);
        if (socket == null) {
            return false;
        }
        final InputStream input;
        input = new BufferedInputStream(socket.getInputStream());
        // Treat everything else as binary for now
        try {
            Util.copyStream(input, local, getBufferSize(), CopyStreamEvent.UNKNOWN_STREAM_SIZE, null, false);
        } finally {
            Util.closeQuietly(input);
            Util.closeQuietly(socket);
        }
        // Get the transfer response
        boolean ok = completePendingCommand();
        return ok;
    }

    @Override
    protected void _prepareDataSocket_(final Socket socket) throws IOException {
        if (socket instanceof SSLSocket) {
            // Control socket is SSL
            final SSLSession session = ((SSLSocket) _socket_).getSession();
            final SSLSessionContext context = session.getSessionContext();
            // context.setSessionCacheSize(preferences.getInteger("ftp.ssl.session.cache.size"));
            try {
                final Field sessionHostPortCache = context.getClass().getDeclaredField("sessionHostPortCache");
                sessionHostPortCache.setAccessible(true);
                final Object cache = sessionHostPortCache.get(context);
                final Method putMethod = cache.getClass().getDeclaredMethod("put", Object.class, Object.class);
                putMethod.setAccessible(true);
                final Method getHostMethod = socket.getClass().getDeclaredMethod("getHost");
                getHostMethod.setAccessible(true);
                final String key = String.format("%s:%s", socket.getInetAddress().getHostName(), String.valueOf(socket.getPort())).toLowerCase(Locale.ROOT);
                putMethod.invoke(cache, key, session);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                // Not running in expected JRE
                System.out.println("No field sessionHostPortCache in SSLSessionContext");
            } catch (Exception e) {
                // Not running in expected JRE
                e.printStackTrace();
            }
        }
    }
}