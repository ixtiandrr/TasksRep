import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bd {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://194.87.214.180/jurina","webadmin","FSBrid52282");
        Statement statement = connection.createStatement();
//        statement.executeQuery("CREATE TABLE MESSAGE (id serial Primary Key, name text, message text)");
        statement.executeQuery("insert into MESSAGE (id, name) values (2, 'User2')");
    }
}
