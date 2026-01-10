package Java强化._07网络编程;

import java.net.*;
import java.util.Enumeration;

public class Main1_Base {
    static void main(String[] args) throws UnknownHostException, SocketException {
//      通信有两种架构：
//      1. 客户端-服务器架构（Client-Server Architecture）
//         - 服务器（Server）：提供服务的计算机或程序，等待客户端的
//           请求并响应。
//         - 客户端（Client）：请求服务的计算机或程序，向服务器
//           发送请求并接收响应。
//
//      2.浏览器-服务器架构（Browser-Server Architecture）
//         - 浏览器（Browser）：一种特殊的客户端，通常用于访问
//           Web 服务，如 Chrome、Firefox 等。
//         - 服务器（Server）：提供 Web 服务的计算机或程序，处理
//           浏览器的请求并返回网页内容。
//
//      IP地址: 设备在网络中的唯一标识符
//      端口号: 用于区分同一设备上不同应用程序APP的通信
//      协议:   通信的规则和标准，传输层常用协议有 TCP 和 UDP


//      获取本机 ip对象
        try {
            // 获取本机 ip对象
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println("本机IP名字: " + ip1.getHostName());
            System.out.println("本机IP地址: " + ip1.getHostAddress());

            // 根据域名获取 ip对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println("百度IP名字: " + ip2.getHostName());
            System.out.println("百度IP地址: " + ip2.getHostAddress());

            System.out.println("1000ms内能否连接百度: "+ip2.isReachable(1000));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
