package com.example.currencyconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner sp_from, sp_to;
    TextView tv_result;
    EditText ed_amount;
    Button bt_clear, bt_swap, bt_convert;
    String [] currency;
    ArrayAdapter<String> spadpt;
    ArrayList value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_clear = (Button) findViewById(R.id.bt3);
        bt_swap = (Button) findViewById(R.id.bt1);
        bt_convert = (Button) findViewById(R.id.bt2);
        tv_result = findViewById(R.id.tv6);

        ed_amount = findViewById(R.id.ed1);
        sp_from = findViewById(R.id.sp1);
        sp_to = findViewById(R.id.sp2);

        currency = getResources().getStringArray(R.array.Currency_array);
        spadpt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,currency);
        sp_from.setAdapter(spadpt);
        sp_to.setAdapter(spadpt);


        value = new ArrayList<>();
        value.add(1.0);
        value.add(0.69881);
        value.add(0.61095);
        value.add(0.93188);
        value.add(0.96680);
        value.add(44.72);
        value.add(73.14);
        value.add(80.55);
        bt_clear.setOnClickListener(this);
        bt_swap.setOnClickListener(this);
        bt_convert.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt2:

                int f = sp_from.getSelectedItemPosition();
                int t = sp_to.getSelectedItemPosition();


                String res =a(f,t);
                tv_result.setText(res);
                tv_result.setTextColor(Color.parseColor("#0092A6"));
                break;

            case R.id.bt3:
                ed_amount.setText("");
                tv_result.setText("");
                tv_result.setTextColor(Color.parseColor("#0092A6"));
                break;


            case R.id.bt1:
                t = sp_from.getSelectedItemPosition();
                f = sp_to.getSelectedItemPosition();

                sp_from.setSelection(f);
                sp_to.setSelection(t);



                if(ed_amount.getText().equals(null))
                {
                    res =a(f,t);
                    tv_result.setText(res);
                    tv_result.setTextColor(Color.parseColor("#0092A6"));
                }
                break;

        }
    }


    public String a(int f,int t){
        double c = Double.parseDouble(value.get(f).toString());
        c = 1 / c;
        double amount = Double.parseDouble(ed_amount.getText().toString());
        c = c * amount;
        double b = Double.parseDouble(value.get(t).toString());
        c = c * b;
        return Double.toString(c);
    }
}




