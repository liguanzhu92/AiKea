package com.example.guanzhuli.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Guanzhu Li on 12/18/2016.
 */
public class DetailDialogFragment extends DialogFragment{
    Button mButtonClose;
    TextView mItemID;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle mArgs = getArguments();
        mItemID = (TextView) rootView.findViewById(R.id.item_id_detail);
        String testvalue = mArgs.getString("ItemID");
        mItemID.setText(testvalue);
        // set title
        getDialog().setTitle("Details");
        mButtonClose = (Button) rootView.findViewById(R.id.close_button);
        mButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return rootView;
    }
}
