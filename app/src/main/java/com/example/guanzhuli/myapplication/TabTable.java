package com.example.guanzhuli.myapplication;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Guanzhu Li on 12/16/2016.
 */
public class TabTable extends ListFragment implements AdapterView.OnItemClickListener {
    public   String[] itemName;
    public   String[] itemID;
    public   Double[] itemPrice;
    public   Integer[] itemPic;
    public List<HashMap<String, String>> aList = new ArrayList<>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*-------------------------------test block------------------------------------------*/
        aList.clear();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("itemName", "testName");
            hm.put("itemID", "TestID");
            hm.put("itemPrice", "100");
            Integer bed = R.drawable.table2;
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
}