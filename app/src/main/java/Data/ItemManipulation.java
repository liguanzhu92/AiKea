package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Guanzhu Li on 12/17/2016.
 */
public class ItemManipulation {
    ArrayList<Item> mItemArrayList;
    ItemManipulation(ArrayList<Item> list) {
        mItemArrayList = list;
    }

    public ArrayList<String> getGroupName(ArrayList<Item> list) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<Item> iter = list.iterator();
        while (iter.hasNext()) {
            Item temp = iter.next();
            result.add(temp.getItemName());
        }
        return result;
    }

    public ArrayList<String> getGroupID(ArrayList<Item> list) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<Item> iter = list.iterator();
        while (iter.hasNext()) {
            Item temp = iter.next();
            result.add(temp.getItemID());
        }
        return result;
    }

    public ArrayList<Double> getGroupPrice(ArrayList<Item> list) {
        Iterator<Item> iter = list.iterator();
        ArrayList<Double> result = new ArrayList<>();
        while (iter.hasNext()) {
            Item temp = iter.next();
            result.add(temp.getPrice());
        }
        return result;
    }

}
