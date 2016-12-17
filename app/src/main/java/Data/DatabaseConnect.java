package Data;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Guanzhu Li on 12/16/2016.
 */
public class DatabaseConnect {
    private static final  String DRIVER = "com.mysql.jdbc.Driver";
    private static final  String URL = "jdbc:mysql://localhost:3306/aikea";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD =  "root";
    public static final String ITEM_ID = "ITEM_ID";
    public static final String ITEM_NAME = "ITEM_NAME";
    public static final String PRICE = "Price";
    public static final String CATEGORY = "Category";
    public static final String LENGTH = "Length";
    public static final String WIDTH = "Width";
    public static final String DESCRIPTION = "Description";
    public static final String DESIGNER = "Designer";
    public static final String IMAGE = "Image";
    // build static block, to load the driver
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException cmf) {
            System.out.println("Error Loading Driver");
            cmf.printStackTrace();
        }
    }
    protected static void addDB(String itemID, String itemName) {
        // from java.sql.Connection;
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "insert into aikea.favourite (ITEM_ID, ITEM_NAME) VALUES (?, ?)";
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.prepareStatement(query);
            stmt.setString(1, itemID);
            stmt.setString(2,itemName);
            stmt.executeUpdate();
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
                    System.out.println("Successfully Add!");
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // get details for certain item
    protected static void itemALLDB(String dbName, String itemID) {
        Connection con = null;
        Statement stmt = null;
        String query = "select * from " + dbName + ".aikea where ITEM_ID="+itemID;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Item> itemSet = new ArrayList<>();
            while (rs.next()) {
                Item temp = new Item.ItemBuilder(itemID, rs.getString(ITEM_NAME), rs.getString(IMAGE),
                        rs.getString(CATEGORY), rs.getDouble(PRICE))
                        .length(rs.getString(LENGTH))
                        .width(rs.getString(WIDTH))
                        .designer(rs.getString(DESIGNER))
                        .discription(rs.getString(DESCRIPTION))
                        .build();
                itemSet.add(temp);
            }
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
                    System.out.println("Successfully Fetch Data!");
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // get all the items in certain category
    protected static void categoryDB(String dbName, String category) {
        Connection con = null;
        Statement stmt = null;
        String query = "select ITEM_ID, ITEM_NAME, Price, Image from " + dbName + ".aikea WHERE Category=" + category;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Item> itemSet = new ArrayList<>();
            while (rs.next()) {
                Item temp = new Item.ItemBuilder(rs.getString(ITEM_ID), rs.getString(ITEM_NAME), rs.getString(IMAGE),
                        category, rs.getDouble(PRICE)).build();
                itemSet.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the connection so important!!!
            try {
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
