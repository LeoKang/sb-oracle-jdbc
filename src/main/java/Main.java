import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "c##mbc", "qwer1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM member");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            var User = new Member(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age"));
            System.out.println(User);
        }
        connection.close();
    }
}
