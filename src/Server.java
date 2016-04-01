import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(new Socket("localhost",7777), 1));
        users.add(new User(new Socket("localhost",8888), 2));
        users.add(new User(new Socket("localhost",9999), 3));
        ArrayList<ServerThread> serverThreadList = new ArrayList<ServerThread>();
        for (User user: users) {
            serverThreadList.add(new ServerThread(user,users));
            serverThreadList.get((user.getI() - 1)).start();
        }

    }
}
