package use.db;

import connect.db.DbConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("John");
        arrayList.add("Salam");

        DbConnection.createTableFromStringToMySql("studentDemo", "name");

        DbConnection.insertDataFromArrayListToMySql(arrayList, "studentDemo", "name");

       List<String> list =  DbConnection.readDatabase("studentDemo", "name");

        for (String str: list  ) {

            System.out.println(str + " ");

        }


    }
}
