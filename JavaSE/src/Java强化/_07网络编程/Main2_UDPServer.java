package Java强化._07网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// UDPClient 客户端
public class Main2_UDPServer {
    static void main(String[] args) throws Exception {
        System.out.println("UDPServer 服务器已启动，等待接收数据包...");
        //1.创建接收端对象, 指定端口号
        DatagramSocket socket = new DatagramSocket(8080);

        //2.创建数据包对象(字节数组, 长度)
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            //3.接收数据包
            socket.receive(packet); // 阻塞式方法, 等待接收数据包

            //4.解析数据包
            System.out.println("对方IP: " + packet.getAddress().getHostAddress());
            System.out.println("对方port: " + packet.getPort());
            String content = new String(buffer,0, packet.getLength());
            System.out.println("收到UDP数据包: " + content);
            System.out.println("---------------------------");
        }

    }
}
