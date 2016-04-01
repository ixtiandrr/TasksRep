import java.io.*;
import java.net.Socket;

public class MyThread extends Thread{
    private Socket s;
    public MyThread(Socket s){
        this.s = s;
    }
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader readMess = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String str = readMess.readLine();
                bw.write(str, 0, str.length());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
