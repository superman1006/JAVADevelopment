package Java强化._07网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main3_TCPServer {
    static void main(String[] args) throws Exception {

//      1.用 ServerSocket 来进行 TCP 的 服务器端
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("TCPServer 服务器端启动，等待客户端连接...");

//      2.调用 accept 方法，等待客户端的连接请求，建立连接后返回一个 Socket 对象
        Socket socket = ss.accept();

//      3.从 Socket 对象中获取输入流, 用于接收客户端发送的数据
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        System.out.println("客户端 IP: "+socket.getInetAddress().getHostAddress());
        System.out.println("客户端 port: " + socket.getPort());
        System.out.println("int: "+dis.readInt());
        System.out.println("double: "+dis.readDouble());
        System.out.println("message: "+dis.readUTF());

    }
}
