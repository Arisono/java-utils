package http;



import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPSClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @describe: 自定义 ftp 主机名称解析
 * @author: xiaowuler
 * @createTime: 2024-03-22 10:49
 */
public class CustomHostnameResolver implements FTPSClient.HostnameResolver {
    private final FTPSClient client;
    private String ip;

    public CustomHostnameResolver(final FTPSClient client, String ip) {
        this.client = client;
        this.ip = ip;
    }

    @Override
    public String resolve(final String hostname) {
        return ip;
    }
}
