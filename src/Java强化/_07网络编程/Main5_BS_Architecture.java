package Java强化._07网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main5_BS_Architecture {
    static void main() throws IOException {
        /*
         * BS架构（Browser-Server，浏览器-服务器）
         *
         * BS架构是一种网络应用架构模式，其中客户端使用浏览器作为用户界面，通过HTTP协议与服务器进行通信。
         * 服务器负责处理业务逻辑、数据存储和响应客户端请求。
         */


        ServerSocket ss = new ServerSocket(8081);
        System.out.println("TCPServer 服务器端启动，等待客户端连接...");

        while (true) {
            Socket socket = ss.accept();
            new ServerThreadWeb(socket).start();
        }


    }

}
class ServerThreadWeb extends Thread{
    private final Socket socket;
    public ServerThreadWeb(Socket socket){
        super();
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 1.服务器接受 web 浏览器(输入 127.0.0.1:8081后)发送的请求
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String requestLine = br.readLine();
            System.out.println("收到请求: " + requestLine);

            // 跳过剩余的请求头
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                // 忽略请求头
            }

            // 2.服务器发送 HTTP 响应给浏览器
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html; charset=UTF-8");
            ps.println("Connection: close");
            ps.println();
            ps.println("<html>");
            ps.println("<head><title>简单的HTTP服务器响应</title></head>");
            ps.println("<body>");
            ps.println("<h1>欢迎访问我的HTTP服务器！</h1>");
            ps.println("<p>这是一个简单的HTTP响应示例。</p>");
            ps.println("</body>");
            ps.println("</html>");
            socket.close();
        } catch (IOException e) {
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"退出...");
        }
    }
}