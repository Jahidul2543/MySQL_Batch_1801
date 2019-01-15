import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ConnectDb {


    /*
     * 1. import
     * 2. load and register driver
     * 3. Create Connection >>> There will be a method to create connection
     * 4. Create Statement >>>> Create statement
     * 5. Execute Query >>>>  method for execution
     * 6. Process the result >>> method for data processing
     * 7. Close
     * */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /**
         * DB URL Structure
         *
         * protocol//[hosts][/database][?properties]
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

        ResultSet resultSet = statement.executeQuery(query); //  createSelectQuery(query)

        /*resultSet.next();

        String studentName1 = resultSet.getString("name");
        System.out.println("First Record:Student Name " + studentName1);

        String student_1_Grade = resultSet.getNString("grade");
        System.out.println("First Record: Student Grade " + student_1_Grade);*/

       ArrayList<String> arrayList = new ArrayList<>();


      /*  ResultSetMetaData metaData = resultSet.getMetaData();
         int nuumberOfColumns = metaData.getColumnCount();*/

        while (resultSet.next()){

            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2)+ " " + resultSet.getString(3));

            arrayList.add(resultSet.getString(1));

        }
        /**
         *
         * Retrieve data from ArrayList
         *
         * */
        for (String str: arrayList) {
            System.out.println("Reading data from arraylist  "+ str);

        }


       /**
        *
        * Close all the resources
        *
        * */
        statement.close();
        connection.close();



    }
}

/**
 *
 *
 * */