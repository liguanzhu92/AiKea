package com.example.guanzhuli.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by Guanzhu Li on 12/19/2016.
 */
public class NewFragment extends Fragment{
    String[] name = {"Androidwarriors", "Stackoverflow", "Developer Android", "AndroidHive",
            "Slidenerd", "TheNewBoston", "Truiton", "HmkCode", "JavaTpoint", "Javapeper"};
    String[] price = {"100", "100", "100", "100", "100", "100", "100", "100", "100", "100"};
    String[] id = {"des", "des2", "des3", "des4", "des5", "des6", "des7", "des8", "des9", "des10"};

    /*--------------------------------GridRecycleAdapter----------------------------------------------------*/
    class GridRecycleAdapter extends RecyclerView.Adapter<RecyclerViewGridHolder>{

        Context context;
        LayoutInflater inflater;
        public GridRecycleAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerViewGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.item_grid, parent, false);
            v.setOnClickListener(new NewFragment.MyOnClickListener());
            RecyclerViewGridHolder viewHolder = new RecyclerViewGridHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewGridHolder holder, int position) {
            holder.tv_name.setText(name[position]);
            holder.tv_price.setText(price[position]);
            holder.tv_id.setText(id[position]);
        }

        @Override
        public int getItemCount() {
            return name.length;
        }
    }

    /*--------------------------------ListRecyclerAdapter----------------------------------------------------*/
    class ListRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewListHolder> {
        Context context;
        LayoutInflater inflater;


        public ListRecyclerAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public RecyclerViewListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.item_listview, parent, false);
            v.setOnClickListener(new NewFragment.MyOnClickListener());
            RecyclerViewListHolder viewHolder = new RecyclerViewListHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewListHolder holder, int position) {
            holder.tv_name.setText(name[position]);
            holder.tv_price.setText(price[position]);
            holder.tv_id.setText(id[position]);
        }

        @Override
        public int getItemCount() {
            return name.length;
        }
    }
    ImageButton mButtonListView;
    ImageButton mButtonGridView;
    RecyclerView mRecyclerView;

    /*---------------------------------onCreateView----------------------------------------------------------------*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_fragment, container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager mListLayoutManager = new LinearLayoutManager(getActivity());
        ListRecyclerAdapter adapterList = new ListRecyclerAdapter(getActivity());

        mRecyclerView.setAdapter(adapterList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mListLayoutManager);
        return view;
    }
    /*---------------------------------------Button initialize----------------------------------------*/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecyclerView.LayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        final RecyclerView.LayoutManager mListLayoutManager = new LinearLayoutManager(getActivity());
        final ListRecyclerAdapter adapterList = new ListRecyclerAdapter(getActivity());
        final GridRecycleAdapter adapterGrid = new GridRecycleAdapter(getActivity());
        mButtonGridView = (ImageButton) getActivity().findViewById(R.id.imageButtonGridView);
        mButtonGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setAdapter(adapterList);
                mRecyclerView.setLayoutManager(mListLayoutManager);
            }
        });
        mButtonListView = (ImageButton) getActivity().findViewById(R.id.imageButtonListView);
        mButtonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setAdapter(adapterGrid);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
            }
        });

    }

    /*--------------------------------------OnClickListener------------------------------------------------------*/
    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            String passName = "select" + itemPosition;
            Bundle args = new Bundle();
            args.putString("ItemID", passName);
            DetailDialogFragment detailDialogFragment = new DetailDialogFragment();
            detailDialogFragment.setArguments(args);
            detailDialogFragment.show(getActivity().getSupportFragmentManager(), "passItemID");
        }
    }
}

/*-------------------------------List-------------------------------------------------*/


 class RecyclerViewListHolder extends RecyclerView.ViewHolder {

    TextView tv_id, tv_name,tv_price;
    ImageView iv_pic;

    public RecyclerViewListHolder(View itemView) {
        super(itemView);

        tv_id = (TextView) itemView.findViewById(R.id.list_id);
        tv_name = (TextView) itemView.findViewById(R.id.list_name);
        tv_price = (TextView) itemView.findViewById(R.id.list_price);
        iv_pic = (ImageView) itemView.findViewById(R.id.list_pic);

    }
}

/*-------------------------Grid-----------------------------------------------*/


class RecyclerViewGridHolder extends RecyclerView.ViewHolder {

    TextView tv_id, tv_name,tv_price;
    ImageView iv_pic;

    public RecyclerViewGridHolder(View itemView) {
        super(itemView);

        tv_id = (TextView) itemView.findViewById(R.id.grid_id);
        tv_name = (TextView) itemView.findViewById(R.id.grid_name);
        tv_price = (TextView) itemView.findViewById(R.id.grid_price);
        iv_pic = (ImageView) itemView.findViewById(R.id.grid_pic);

    }
}
