package com.example.guanzhuli.myapplication;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Guanzhu Li on 12/16/2016.
 */
public class TabHome extends ListFragment{
    public   String[] cateName;
    public   Integer[] catePic;
    public List<HashMap<String, String>> aList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cateName = new String[]{"Bed", "Sofa", "Table"};
        catePic = new Integer[]{R.drawable.bed, R.drawable.sofa,R.drawable.table};
        aList.clear();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("cateName", cateName[i]);
            hm.put("catePic", Integer.toString(catePic[i]));
            aList.add(hm);
        }
        String[] from = {"cateName", "catePic"};
        int[] to = {R.id.cur, R.id.flag};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.fragment_main, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "it is " + position, Toast.LENGTH_SHORT).show();
        TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
        tabhost.getTabAt(position+1).select();
    }
}