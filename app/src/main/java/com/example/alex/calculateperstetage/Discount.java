package com.example.alex.calculateperstetage;


import android.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Discount extends Fragment {
    private TextView textView;
    private EditText editNumber;
    private EditText editPercentage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discount, null);
        textView = (TextView) v.findViewById(R.id.textViewDiscont);

        editNumber = (EditText) v.findViewById(R.id.editTextDiscont);
        editPercentage = (EditText) v.findViewById(R.id.editText2Discont);
        editNumber.setOnKeyListener(editEvenNumb());
        editPercentage.setOnKeyListener(editEvenNumb());
        return v;

    }

    private View.OnKeyListener editEvenNumb() {
        return new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    calculate();
                }
                return false;
            }
        };
    }

    private void calculate() {
        if (!editNumber.getText().toString().equals("") && !editPercentage.getText().toString().equals("")) {
            double number = Double.parseDouble(editNumber.getText().toString());
            double percentage = Double.parseDouble(editPercentage.getText().toString());
            double answer = (number * percentage) / 100;
            textView.setText(answer + "");
        }

    }

}
