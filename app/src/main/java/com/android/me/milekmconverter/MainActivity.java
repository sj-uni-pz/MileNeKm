package com.android.me.milekmconverter;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FirstFragment.MyListener {

    private static final String TAG = "MainActivity";
    public static final String KM_KEY = "com.android.me.milekmconverter.MainActivity.km";
    public static final String MILE_KEY = "com.android.me.milekmconverter.MainActivity.mile";
    private FirstFragment fragment;
    private String value;
    private String unit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            // Insert detail fragment based on the item passed
            fragment = new FirstFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.firstFragmentContainer, fragment);
            ft.commit();
        }

    }

    public void sendResult(View view) {
        Log.d(TAG,String.format("VALUE = %s; UNIT = %s %n", value,unit));
        double v = Double.parseDouble(value);
        double km;
        double mile;
        if (unit.equals("KM")) {
            km = v;
            mile = km * 0.621371;
        }
        else {
            mile = v;
            km = mile/0.621371;
        }
        Intent i = new Intent(this,ResultActivity.class);
        i.putExtra(KM_KEY,km);
        i.putExtra(MILE_KEY,mile);
        startActivity(i);
    }

    @Override
    public void onItemSelected(String selectedUnit) {
        unit = selectedUnit;
    }

    @Override
    public void onTextChanged(String text) {
        value =text;
    }
}
