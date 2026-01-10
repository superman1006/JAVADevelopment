package Java强化._07网络编程;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main3_TCPClient {
    static void main(String[] args) throws Exception {
        /**
         *  TCP: 传输控制协议（Transmission Control Protocol）
         *  特点:
         *    1. 面向连接: 发送数据前需要建立连接，类似于打电话前先拨号
         *    2. 可靠传输: 保证数据包的到达顺序和完整性，丢失的数据包会被重传
         *    3. 速度较慢: 由于面向连接和可靠传输，传输速度较慢，适合对数据完整性要求高的应用
         */

//      用 Socket 来创建 TCP 的 客户端
//      1.用 Socket 创建客户端对象，连接服务器端（对方主机号,对方端口号）
        Socket socket = new Socket("127.0.0.1", 8080);

//      2.从 Socket 对象中获取输出流, 用于发送数据到服务器端
        OutputStream os = socket.getOutputStream();
//      把os转换成dos
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeDouble(1.1);
        dos.writeUTF("Hello");

        socket.close();
    }
}
