package use.db;

import connect.db.DbConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UseDb {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        List<String> data = DbConnection.readDatabase("students","id", "name", "grade");

        for (String str : data) {

            System.out.print(str + " ");

        }
    }
}

