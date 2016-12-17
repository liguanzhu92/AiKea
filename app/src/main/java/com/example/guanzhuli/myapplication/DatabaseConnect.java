package com.example.guanzhuli.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Guanzhu Li on 12/16/2016.
 */
public class DatabaseConnect {
    private static final  String DRIVER = "com.mysql.jdbc.Driver";
    private static final  String URL = "jdbc:mysql://localhost:3306/aikea";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD =  "root";
    // build static block, to load the driver
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException cmf) {
            System.out.println("Error Loading Driver");
            cmf.printStackTrace();
        }
    }
    protected static void executeQuery(String query) {
        // from java.sql.Connection;
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the connection so important!!!
            try {
                if (con != null) {
                    System.out.println("Successful Connected");
                    con.close();
                }
                if (stmt != null) {
                    System.out.println("Successfully Modify!");
                    stmt.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
