package Java强化._07网络编程.Main4_多发TCP_重要;


import java.net.ServerSocket;
import java.net.Socket;

public class Main4_TCPServer {
    static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("TCPServer 服务器端启动，等待客户端连接...");


        while (true) {
            Socket socket = ss.accept(); // 等待客户端连接
            new ServerThread(socket).start();
        }
    }
}
