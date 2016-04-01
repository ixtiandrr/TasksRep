import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        BufferedReader readMess = new BufferedReader(new InputStreamReader(System.in));
        MyThread t = new MyThread(s);
        t.start();
        while(true) {


            System.out.println(br.readLine());



                /*String str = readMess.readLine();
                bw.write(str, 0, str.length());
                bw.newLine();
                bw.flush();*/
        }
    }
}
