package Java强化._07网络编程.Main4_多发TCP_重要;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main4_TCPClient {
    static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);
        while (true) {
            String content = sc.nextLine();
            if(content.equals("exit")) {
                break;
            }
            dos.writeUTF(content);
        }
    }
}
