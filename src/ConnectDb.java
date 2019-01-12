import java.sql.*;

public class ConnectDb {


    /*
     * 1. import
     * 2. load and register driver
     * 3. Create Connection
     * 4. Create Statement
     * 5. Execute Query
     * 6. Process the result
     * 7. Close
     * */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /**
         * DB URL Structure
         *
         * protocol//[hosts][/database][?properties]
         *
         * jdbc:mysql://localhost:3306/testdb
         *
         *
         *
         * */
        String url = "jdbc:mysql://localhost:3306/testdb";
        String userName = "root";
        String passWord = "root";
        String query = "select * from students";

        // Load and register driver

        Class.forName("com.mysql.jdbc.Driver");

       /**
        * Establish a connection with MySQL Server
        * */
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        /**
         * Thinking about what to say
         * */
        Statement statement = connection.createStatement();

        /**
         * Using this statement reference we will execute the query
         * And store the processed data in ResultSet
         * */

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        String studentName1 = resultSet.getString("name");
        System.out.println("First Record:Student Name " + studentName1);

        String student_1_Grade = resultSet.getNString("grade");
        System.out.println("First Record: Student Grade " + student_1_Grade);



       /**
        *
        * Close all the resources
        *
        * */
        statement.close();
        connection.close();



    }
}
