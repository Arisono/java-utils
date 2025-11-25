package http;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.util.TrustManagerUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * created by liuj on 2024/1/19/019
 *
 * @author liuj
 * 2024/1/19/019 14:15
 */
public class FTPClientUtils {

    private static final String TAG = "FTPClientFunctions";

    private FTPSClient ftpClient = null; // FTP客户端

    /**
     * 连接到FTP服务器
     *
     * @param host     ftp服务器域名
     * @param username 访问用户名
     * @param password 访问密码
     * @param port     端口
     * @return 是否连接成功
     */
    public boolean ftpConnect(String host, String username, String password, int port) {
        try {
            // SSLContext context=SSLContext.getInstance("TLS");
            // context.init(null,new TrustManager[]{TrustManagerUtils.getAcceptAllTrustManager()},null);
            ftpClient = new FTPSClient();
            // ftpClient.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
            // XLog.tag(TAG).d( "connecting to the ftp server " + host + " ：" + port);
            System.out.println("connecting to the ftp server " + host + " ：" + port);
            ftpClient.connect(host, port);
            // XLog.tag(TAG).d( "connecting to the ftp server " + host + " ：" + port+" code:"+ftpClient.getReplyCode());
            System.out.println("connecting to the ftp server " + host + " ：" + port + " code:" + ftpClient.getReplyCode());
            // 根据返回的状态码，判断链接是否建立成功
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                //  XLog.tag(TAG).d( "login to the ftp server");
                boolean status = ftpClient.login(username, password);
                /*
                 * 设置文件传输模式
                 * 避免一些可能会出现的问题，在这里必须要设定文件的传输格式。
                 * 在这里我们使用BINARY_FILE_TYPE来传输文本、图像和压缩文件。
                 */
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                String[] protocols = ftpClient.getEnabledProtocols();
                String[] cipherSuites = ftpClient.getEnabledCipherSuites();
                // XLog.tag(TAG).d(" protocols:"+ Arrays.toString(protocols)+"  cipherSuites:"+Arrays.toString(cipherSuites));
                System.out.println(" protocols:" + Arrays.toString(protocols) + "  cipherSuites:" + Arrays.toString(cipherSuites));
                ftpClient.enterLocalPassiveMode();

                System.out.println("status:" + status);
                return status;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //   XLog.tag(TAG).d( "Error: could not connect to host " + host);
            System.out.println(" e:" + e.getLocalizedMessage());
        }
        return false;
    }

    /**
     * 断开ftp服务器连接
     *
     * @return 断开结果
     */
    public boolean ftpDisconnect() {
        // 判断空指针
        if (ftpClient == null) {
            return true;
        }

        // 断开ftp服务器连接
        try {
            ftpClient.logout();
            ftpClient.disconnect();
            return true;
        } catch (Exception e) {
            //XLog.tag(TAG).d(  "Error occurred while disconnecting from ftp server.");
        }
        return false;
    }

    /**
     * ftp 文件上传
     *
     * @param srcFilePath  源文件目录
     * @param desFileName  文件名称
     * @param desDirectory 目标文件
     * @return 文件上传结果
     */
    public boolean ftpUpload(String srcFilePath, String desFileName, String desDirectory) {
        boolean status = false;
        try {
            FileInputStream srcFileStream = new FileInputStream(srcFilePath);
            status = ftpClient.storeFile(desFileName, srcFileStream);
            srcFileStream.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            // XLog.tag(TAG).d(  "upload failed: " + e.getLocalizedMessage());
        }
        return status;
    }

    /**
     * ftp 更改目录
     *
     * @param path 更改的路径
     * @return 更改是否成功
     */
    public boolean ftpChangeDir(String path) {
        boolean status = false;
        try {
            status = ftpClient.changeWorkingDirectory(path);
        } catch (Exception e) {
            e.printStackTrace();
            // XLog.tag(TAG).d( "change directory failed: " + e.getLocalizedMessage());
        }
        return status;
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //                  //"ftp.cloud.vatilon.com","android","hCB8kHJcSwFCTJDn",21
                // ftp.cloud.vatilon.com:10021   android    hCB8kHJcSwFCTJDn

                //ftp.vatilon.com
                //app q3WcUI072jVhBYr8
                //1231
                FTPClientUtils ftpClient = new FTPClientUtils();
                //   boolean connectResult =ftpClient.ftpConnect("ftp.cloud.vatilon.com","android","hCB8kHJcSwFCTJDn",21);
                boolean connectResult = ftpClient.ftpConnect("ftp.vatilon.com", "app", "q3WcUI072jVhBYr8", 1231);
                System.out.println("connectResult:" + connectResult);
                if (connectResult) {
                    boolean changeDirResult = ftpClient.ftpChangeDir("/");
                    System.out.println("ftpChangeDir:" + changeDirResult);
                    if (changeDirResult) {
                        File localFile = new File("C:\\Users\\Administrator\\Desktop\\CERT.RSA");
                        boolean uploadResult = ftpClient.ftpUpload(localFile.getAbsolutePath(), "CERT.RSA", "");
                        System.out.println("uploadResult:" + uploadResult);
                    }
                }
            }
        }).start();

    }


    /**
     * 上传闪退日志文件
     *
     * @param sourceFilePath 日志文件路径
     * @param descFileName   ftp 文件名称
     * @param ftpDirName     ftp 子目录（native,java,anr）
     */
    public static void uploadFTPFile(FTPClientUtils ftpClient, String sourceFilePath, String descFileName, String ftpDirName) {

//      if (connectResult) {
        boolean changeDirResult = ftpClient.ftpChangeDir("/" + ftpDirName);
        //  XLog.tag(TAG).w("uploadFTPFile ftpChangeDir:"+changeDirResult+" ftpDirName:"+ftpDirName);
        if (changeDirResult) {
            ///sdcard/Android/data/com.htl.app/files/AndroidBeta/Logs/exception_dmp/f19bad9e-b0be-486e-a430f392-77d0d967.dmp
            //                  String sourceFilePath= FileUtils.getNDKCrashFilePath()+"f19bad9e-b0be-486e-a430f392-77d0d967.dmp";
            //                  String descFileName="f19bad9e-b0be-486e-a430f392-77d0d967.dmp";
            boolean uploadResult = ftpClient.ftpUpload(sourceFilePath, descFileName, "");
            if (uploadResult) {
                File logFile = new File(sourceFilePath);
                // FileUtils.delete(logFile);
                //  XLog.tag(TAG).w( "上传成功! 日志文件："+sourceFilePath);
                //                     boolean disConnectResult = ftpClient.ftpDisconnect();
                //                     if(disConnectResult) {
                //                        XLog.tag(TAG).w( "关闭ftp连接成功");
                //                     } else {
                //                        XLog.tag(TAG).w(  "关闭ftp连接失败");
                //                     }
            } else {
                // XLog.tag(TAG).w(  "上传失败");
            }
        } else {
            // XLog.tag(TAG).w( "切换ftp目录失败");
        }
//      }else{
//         XLog.tag(TAG).w( "连接ftp服务器失败");
//      }
    }
}

