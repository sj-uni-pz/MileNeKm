package com.android.me.milekmconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ME on 1/16/2017.
 */

public class ResultFragment extends Fragment {

    private double km;
    private double mile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        km = getArguments().getDouble(MainActivity.KM_KEY);
        mile = getArguments().getDouble(MainActivity.MILE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment,container,false);
        TextView kmTextView = (TextView) view.findViewById(R.id.kmTextView);
        TextView mileTextView = (TextView) view.findViewById(R.id.mileTextView);
        kmTextView.setText(String.format("%.2f KM %n",km));
        mileTextView.setText(String.format("%.2f mile %n",mile));
        return view;
    }


    // ItemDetailFragment.newInstance(item)
    public static ResultFragment newInstance(double km,double mile) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putSerializable(MainActivity.KM_KEY, km);
        args.putSerializable(MainActivity.MILE_KEY, mile);
        fragment.setArguments(args);
        return fragment;
    }

}
