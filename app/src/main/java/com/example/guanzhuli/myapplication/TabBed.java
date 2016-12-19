package com.example.guanzhuli.myapplication;


import Data.DatabaseConnect;
import Data.Item;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Guanzhu Li on 12/16/2016.
 */
public class TabBed extends ListFragment implements AdapterView.OnItemClickListener {
    public   String[] itemName;
    public   String[] itemID;
    public   Double[] itemPrice;
    public   Integer[] itemPic;
    public List<HashMap<String, String>> aList = new ArrayList<>();
    SimpleAdapter adapter;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        //arrayManipulation();
/*        DBConnectTask temp = new DBConnectTask();
        temp.execute();*/

/*-------------------------------test block------------------------------------------*/
        aList.clear();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("itemName", "testName");
            hm.put("itemID", "TestID");
            hm.put("itemPrice", "300");
            Integer bed = R.drawable.bed1;
            hm.put("itemPic", Integer.toString(bed));
            aList.add(hm);
        }
/*-------------------------------------------------------------------------*/
        String[] from={"itemPic","itemName","itemID", "itemPrice"};
        int[] to={R.id.pic,R.id.item_name, R.id.item_id, R.id.item_price};
        adapter = new SimpleAdapter(getActivity(), aList,R.layout.fragment_cate, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

/*    class DBConnectTask extends AsyncTask <Void, Void, ArrayList<Item> >{
        ArrayList<Item> itemList;
        @Override
        protected ArrayList<Item> doInBackground(Void... voids) {
*//*            DatabaseConnect dbcn = new DatabaseConnect();*//*
*//*            itemList = dbcn.categoryDB("item", "Bed");*//*
*//*--------------------------------test connection---------------------------------------------------------*//*
            String DRIVER = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://192.168.1.100:3306/aikea";
            String USERNAME = "root";
            String PASSWORD =  "root";
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException cmf) {
                System.out.println("Error Loading Driver");
                cmf.printStackTrace();
            }
            Connection con = null;
            PreparedStatement stmt = null;
            String query = "insert into aikea.favourite (ITEM_ID, ITEM_NAME) VALUES (?, ?)";
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                stmt = con.prepareStatement(query);
                stmt.setString(1, "bed006");
                stmt.setString(2, "bed test");
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
            return itemList;
        }

        @Override
        protected void onPostExecute(ArrayList<Item> items) {

            Iterator<Item> iter = itemList.iterator();
            ArrayList<String> mItemName = new ArrayList<>();
            ArrayList<String> mItemID = new ArrayList<>();
            ArrayList<Double> mItemPrice = new ArrayList<>();
            ArrayList<Integer> mItemPic = new ArrayList<>();
            while (iter.hasNext()) {
                Item temp = iter.next();
                mItemName.add(temp.getItemName());
                mItemID.add(temp.getItemID());
                mItemPrice.add(temp.getPrice());
                Integer picID = getResId(temp.getImage(), R.drawable.class);
                mItemPic.add(picID);
            }
            itemName = mItemName.toArray(itemName);
            itemID = mItemID.toArray(itemID);
            itemPrice = mItemPrice.toArray(itemPrice);
            itemPic = mItemPic.toArray(itemPic);
            mapRes();
        }
    }*/
/*    // initialize array
    private void arrayManipulation() {
        DatabaseConnect dbcn = new DatabaseConnect();
        ArrayList<Item> itemList = dbcn.categoryDB("item", "Bed");

        Iterator<Item> iter = itemList.iterator();
        ArrayList<String> mItemName = new ArrayList<>();
        ArrayList<String> mItemID = new ArrayList<>();
        ArrayList<Double> mItemPrice = new ArrayList<>();
        ArrayList<Integer> mItemPic = new ArrayList<>();
        while (iter.hasNext()) {
            Item temp = iter.next();
            mItemName.add(temp.getItemName());
            mItemID.add(temp.getItemID());
            mItemPrice.add(temp.getPrice());
            Integer picID = getResId(temp.getImage(), R.drawable.class);
            mItemPic.add(picID);
        }
        itemName = mItemName.toArray(itemName);
        itemID = mItemID.toArray(itemID);
        itemPrice = mItemPrice.toArray(itemPrice);
        itemPic = mItemPic.toArray(itemPic);
    }*/
    // map the resources
    private void mapRes() {
        for (int i = 0; i <  itemID.length; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("itemName", itemName[i]);
            hm.put("itemID", itemID[i]);
            hm.put("itemPrice", String.valueOf(itemPrice[i]));
            hm.put("itemPic", Integer.toString(itemPic[i]));
            aList.add(hm);
        }
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}