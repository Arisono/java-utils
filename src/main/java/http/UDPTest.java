package http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class UDPTest {

    public static void main(String[] args) {
        InetAddress group = null;
        try {
            group = InetAddress.getByName("224.0.0.1");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 1314;
        MulticastSocket ms = null;

        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);//加入到组播组
            while (true) {
                String message = "Hello " + new java.util.Date();
                byte[] buffer = message.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                ms.send(dp);//发送组播数据报
                System.out.println("发送数据报给" + group + ":" + port);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                }

            }
        }

    }
}
