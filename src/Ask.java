import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Ask {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://194.87.214.180/jurina", "webadmin", "FSBrid52282");
        BufferedReader readMess = new BufferedReader(new InputStreamReader(System.in));
        String str = readMess.readLine();
        char[] charArray = new char[str.length()];
        charArray = str.toCharArray();
        String par = new String();
        int i = 0;
        for (Character ch : charArray) {
            if (ch.equals('\061')) break;
            System.out.println(par);
            par = par + ch;
            i++;
        }
        if (i == str.length()) System.out.println("введите id или name");
        String str2 = new String();
        for (int j = i + 1; j <= str.length(); j++) {
            str2 = str2 + charArray[j];
        }
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from message");
        if (execute) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                if (par.equals("id")) {
                    String str3 = "id: " + resultSet.getString(1) + "; name: " + resultSet.getString(2) + "; message: " + resultSet.getString(3);
                }
                if (par.equals("name")) {

                }
            }
        }
    }
}
