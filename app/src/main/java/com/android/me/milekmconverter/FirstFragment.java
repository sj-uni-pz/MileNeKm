package com.android.me.milekmconverter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by ME on 1/15/2017.
 */

public class FirstFragment extends Fragment {

    private EditText valueEditText;
    private Spinner unitSpinner;
    private MyListener listener;

    public interface MyListener {
        public void onItemSelected(String selectedUnit);
        public void onTextChanged(String text);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        valueEditText = (EditText)view.findViewById(R.id.valueEditText);
        valueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                listener.onTextChanged(valueEditText.getText().toString());
            }
        });

        unitSpinner = (Spinner)view.findViewById(R.id.spinner);
        unitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String unit = unitSpinner.getSelectedItem().toString();
                listener.onItemSelected(unit);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyListener) {
            listener = (MyListener) context;
        } else {
            throw new ClassCastException(
                    context.toString()
                            + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }





}
