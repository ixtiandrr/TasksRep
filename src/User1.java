import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class User1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        MyThread t = new MyThread(s);
        t.start();
        while(true) {
            System.out.println(br.readLine());
        }
    }
}
