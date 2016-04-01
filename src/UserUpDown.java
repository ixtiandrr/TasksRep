import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UserUpDown {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket soketDown = new Socket("localhost",7777);
        Socket socketUp = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socketUp.getInputStream()));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soketDown.getOutputStream()));
        BufferedReader readMess = new BufferedReader(new InputStreamReader(System.in));

        MyThread t = new MyThread(socketUp);
        t.start();
        while(true) {

            System.out.println(br.readLine());
        }
    }
}
