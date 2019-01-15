package test;

import connect.db.DbConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DbConnectionUnitTest {
/**
 * readDatabase() Unit Test
 *
 *
 * */
    @Test
    public void readDatabseTest() throws SQLException, IOException, ClassNotFoundException {

        List<String> list =  DbConnection.readDatabase("studentDemo", "name");
        Assert.assertEquals(list.get(0), "John");
        System.out.println("Test Passed, readDatabase() is functional");

    }
}
