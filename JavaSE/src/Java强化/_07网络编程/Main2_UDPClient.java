package Java强化._07网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

// UDPClient 客户端
public class Main2_UDPClient {
    static void main(String[] args) throws Exception {
        /**
         *  UDP: 用户数据报协议（User Datagram Protocol）
         *  特点:
         *  1. 无连接: 发送数据前不需要建立连接，直接发送数据报
         *  2. 不可靠: 不保证数据包的到达顺序和完整性，可能丢失或重复
         *  3. 速度快: 由于无连接和不可靠，传输速度较快，适合实时应用
         */

//      使用 DatagramSocket来发送和接收UDP数据包
//          (先启动服务器端，再启动客户端,客户端可以多开,服务器端可以接收多个客户端发送的数据包)
        System.out.println("UDPClient 客户端启动，准备发送数据包...");

//      1.创建发送端对象
        DatagramSocket socket = new DatagramSocket();


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要发送的内容(输入exit退出): ");
            String content = sc.nextLine();
            if (content.equals("exit")) {
                System.out.println("UDPClient 客户端已退出");
                socket.close();
                break;
            }
            // 2.创建数据包对象(字节数组, 长度, 目标IP, 目标端口)
            byte[] content_bytes = content.getBytes();
            DatagramPacket packet = new DatagramPacket(content_bytes, content_bytes.length, InetAddress.getLocalHost(), 8080);

            // 3.发送端发送数据包
            socket.send(packet);
            System.out.println("UDP数据包已发送");
        }
    }
}
