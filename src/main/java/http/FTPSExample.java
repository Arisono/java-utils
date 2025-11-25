package http;


import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.util.TrustManagerUtils;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

//425 Unable to build data connection: TLS session of data connection not resumed.   TLS1.3

//-Dsun.security.ssl.enableSessionCreation=true -Dsun.security.ssl.enableSessionResumption=true -Djavax.net.debug=ssl,handshake -Dhttps.protocols=TLSv1.3
//--add-opens java.base/sun.security.util=ALL-UNNAMED --add-opens java.base/sun.security.ssl=ALL-UNNAMED -Djdk.tls.client.protocols=TLSv1.3,TLSv1.2 -Djdk.tls.allowLegacyResumption=true -Djdk.tls.useExtendedMasterSecret=false -Djdk.tls.client.enableSessionTicketExtension=false
public class FTPSExample {

    public FTPSExample() {
    }

    private static void showServerReply(FTPSClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String reply : replies) {
                System.out.println("SERVER: " + reply);
            }
        }
    }



    public static void main(String[] args) {
        //   // 创建使用 BouncyCastle JSSE Provider 的 SSLContext
        //            SSLContext sslContext = SSLContext.getInstance("TLS", "BCJSSE");
        //            sslContext.init(null, null, null);

//        Security.addProvider(new BouncyCastleJsseProvider());
        String server = "ftp.vatilon.com";//113.87.250.19  ftp.vatilon.com
        int port = 1231;
        String user = "app";
        String pass = "q3WcUI072jVhBYr8";

        String enableSessionCreation = System.getProperty("sun.security.ssl.enableSessionCreation");
        String enableSessionResumption = System.getProperty("sun.security.ssl.enableSessionResumption");

        System.out.println("sun.security.ssl.enableSessionCreation: " + enableSessionCreation);
        System.out.println("sun.security.ssl.enableSessionResumption: " + enableSessionResumption);

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                    }
                }
        };

        try {
            // 启用 SSL 调试模式
            System.setProperty("javax.net.debug", "ssl,handshake");
//          // 创建使用 BouncyCastle JSSE Provider 的 SSLContext
//            SSLContext sslContext = SSLContext.getInstance("TLSv1.3", "BCJSSE");
//            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());


//            SSLContext sc = SSLContext.getInstance("TLSv1.3");//v1.3
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            // 设置 SSL/TLS 会话恢复机制
//            SSLSessionReuseFTPSClient ftpsClient = new SSLSessionReuseFTPSClient();//"TLS", false
            // 创建 FTPSClient 并使用自定义的 SSLContext
            SSLSessionReuseFTPSClient ftpsClient = new SSLSessionReuseFTPSClient();

             ftpsClient.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager()); // Use a proper TrustManager in production
            ftpsClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
            // 设置连接和数据超时

            // 设置支持的协议和加密套件
//            ftpsClient.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
//            ftpsClient.setEnabledCipherSuites(new String[] {
//                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
//                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
//                    "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256"
//            });

//            ftpsClient.setUseClientMode(true);
//            ftpsClient.setNeedClientAuth(false);

//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

//             ftpsClient.setSocketFactory(sslContext.getSocketFactory());
            // 启用调试信息（可选）
            System.setProperty("javax.net.debug", "ssl,handshake,data,sslctx");

          //  ftpsClient.setRemoteVerificationEnabled(false);
            try {
                // 连接到服务器
                ftpsClient.connect(server, port);
                System.out.println("Connected to " + server);
                // 检查回复代码以确保成功连接
                int reply = ftpsClient.getReplyCode();
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpsClient.disconnect();
                    throw new IOException("Exception in connecting to FTP Server");
                }
                // 登录
                boolean login = ftpsClient.login(user, pass);
                if (login) {

                    System.out.println("Login successful");
                    // 设置文件传输模式为二进制
                    ftpsClient.setFileType(FTP.BINARY_FILE_TYPE);
                    // 设置数据通道保护级别
                    ftpsClient.execPBSZ(0);
                    ftpsClient.execPROT("P");

                    // 请求服务器功能列表
//                    ftpsClient.feat();
                    // 强制重用会话
                    ftpsClient.setDataTimeout(10000);
                    ftpsClient.setControlKeepAliveTimeout(10000);
                    // 切换到被动模式

                    ftpsClient.enterLocalPassiveMode();

//                    ftpsClient.setEnabledSessionCreation(true);

//                    FTPFile[] files = ftpsClient.listFiles();
//
//                    for (FTPFile file : files) {
//                        System.out.println("根目录：fileName:" + file.getName());
//                    }

                    File localFile = new File("C:\\Users\\Administrator\\Desktop\\txt.txt");
                    String remoteFile = "/native_crash/txt.txt";
                    FileInputStream inputStream = new FileInputStream(localFile);
                    boolean success = ftpsClient.storeFile(remoteFile, inputStream);
                    showServerReply(ftpsClient);
                    System.out.println("文件上传是否成功?" + success);
                    inputStream.close();
                    // 退出登录
//                    ftpsClient.logout();
                } else {
                    System.out.println("Login failed");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
//                try {
//                    if (ftpsClient.isConnected()) {
//                        ftpsClient.disconnect();
//                        System.out.println("Disconnected from server");
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
            }
        } catch (Exception ex) {//NoSuchAlgorithmException | KeyManagementException ex
            ex.printStackTrace();
        }

//
//        while (true) {
//
//        }

//        //ftp.vatilon.com
//        //app q3WcUI072jVhBYr8
//        //1231
//        String server = "ftp.vatilon.com";
//        int port = 1231;
//        String username = "app";
//        String password = "q3WcUI072jVhBYr8";
//        FTPSClient ftpsClient = new FTPSClient("TLS");
//        ///ftpsClient.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
//        try {
//            // 设置SSL连接相关配置
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
////            FileInputStream keyStoreFile = new FileInputStream("path-to-key-store-file");
////            keyStore.load(keyStoreFile, "key-store-password".toCharArray());
////            keyStoreFile.close();
//         //   keyManagerFactory.init(keyStore, "key-store-password".toCharArray());
//            TrustManager[] trustManagers = new TrustManager[]{TrustManagerUtils.getAcceptAllTrustManager()};//trustManagerFactory.getTrustManagers()
////            trustManagers
//            sslContext.init(null, trustManagers, null);
//           // ftpsClient.setContext(sslContext);
//            ftpsClient = new FTPSClient(sslContext);
//            // 连接到FTP服务器
//            ftpsClient.connect(server, port);
//            ftpsClient.login(username, password);
//            // 设置文件传输模式为二进制
//            ftpsClient.setFileType(FTP.BINARY_FILE_TYPE);
//            // 上传文件
//            File localFile = new File("C:\\Users\\Administrator\\Desktop\\CERT.RSA");
//            String remoteFile = "CERT.RSA";
//            FileInputStream inputStream = new FileInputStream(localFile);
//           boolean success= ftpsClient.storeFile(remoteFile, inputStream);
//            inputStream.close();
//            System.out.println("文件上传成功?"+success);
//            // 下载文件
////            String downloadFile = "remote-file.txt";
////            FileOutputStream outputStream = new FileOutputStream("downloaded-file.txt");
////            ftpsClient.retrieveFile(downloadFile, outputStream);
////            outputStream.close();
////            System.out.println("文件下载成功");
//            // 断开连接
//            ftpsClient.logout();
//            ftpsClient.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }



}







