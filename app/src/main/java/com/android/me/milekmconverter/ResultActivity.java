package com.android.me.milekmconverter;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private ResultFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        double km  = getIntent().getDoubleExtra(MainActivity.KM_KEY,0);
        double mile  = getIntent().getDoubleExtra(MainActivity.MILE_KEY,0);
        if (savedInstanceState == null) {
            // Insert detail fragment based on the item passed
            fragment =  ResultFragment.newInstance(km,mile);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.resultFragmentContainer, fragment);
            ft.commit();
        }

    }
}
