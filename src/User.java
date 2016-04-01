import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private BufferedWriter bw;
    private BufferedReader br;
    private int i;
    public User (Socket s, int i) throws IOException {
        this.i = i;
        this.bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    public BufferedWriter getBw(){
        return bw;
    }
    public int getI() {
        return i;
    }

    public void sendMess(ArrayList<User> users, Connection connection) throws IOException, SQLException {
        String str = br.readLine();
//        Connection connection = DriverManager.getConnection("jdbc:postgresql://194.87.214.180/jurina", "webadmin", "FSBrid52282");
        Statement statement = connection.createStatement();
        statement.execute("insert into MESSAGE ( name, message) values ( 'User" + this.getI() + "', '" + str + "')");
        for (User user: users) {
            if (user.getI() != i) {
                user.getBw().write(str, 0, str.length());
                user.getBw().newLine();
                user.getBw().flush();
            }
        }
    }


}
