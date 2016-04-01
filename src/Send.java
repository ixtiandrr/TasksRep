import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Send {
    public static void main(String[] args) throws IOException {


        Socket s = new Socket("localhost",8888);
        MyThread t1 = new MyThread(s);
        t1.start();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        BufferedReader readMess = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while(true) {


            /*String str = readMess.readLine();
            bw.write(str, 0, str.length());
            bw.newLine();
            bw.flush();*/



            System.out.println(br.readLine());
        }
    }
}
