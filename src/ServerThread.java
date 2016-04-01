import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private User user;
    private ArrayList<User> users;
    public ServerThread(User user, ArrayList<User> users){
        this.users = users;
        this.user = user;
    }
//123
    public void run() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://194.87.214.180/jurina", "webadmin", "FSBrid52282");
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("select * from message");
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    for (User user: users) {
                        String str = resultSet.getString(2) + ": " + resultSet.getString(3);
                        user.getBw().write(str, 0, str.length());
                        user.getBw().newLine();
                        user.getBw().flush();
                    }
//                    System.out.println(resultSet.getString(2) + ": " + resultSet.getString(3));
                }
            }
            while(true){
                user.sendMess(users, connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
