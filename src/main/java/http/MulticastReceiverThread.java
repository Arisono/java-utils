package http;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

/**
 * udp组播
 *
 * @author liuj
 * 2023/11/30/030 17:07
 */
public class MulticastReceiverThread extends Thread {

    @Override
    public void run() {
        System.out.println("MulticastReceiverThread start.....");
        InetAddress group = null;
        try {
            group = InetAddress.getByName("224.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int port = 1314;
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.setNetworkInterface(NetworkInterface.getByName("wlan0"));
            ms.joinGroup(group);//加入到组播组
            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);//接收组播数据报
                String s = new String(dp.getData(), 0, dp.getLength());
                //XLog.d("multicastReceiverThread s:" + s);
                System.out.println("multicastReceiverThread s:" + s);
            }
        } catch (IOException e) {
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

    public static void main(String[] args) {
        MulticastReceiverThread multicastReceiverThread=new MulticastReceiverThread();
        multicastReceiverThread.start();
    }
}
