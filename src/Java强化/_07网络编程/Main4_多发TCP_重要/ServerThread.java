package Java强化._07网络编程.Main4_多发TCP_重要;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        super();
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println("客户端 IP: "+socket.getInetAddress().getHostAddress()+" connecting...");
            while (true) {
                System.out.println(socket.getInetAddress().getHostAddress()+": message: "+dis.readUTF());
            }
        } catch (IOException e) {
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"退出...");
        }
    }
}
