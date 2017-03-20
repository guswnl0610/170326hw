package com.example.guswn_000.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Reservation extends AppCompatActivity {

    Button prevbtn,nextbtn;
    DatePicker dp;
    TimePicker tp;
    GridLayout glayout;
    TextView timertv,date,time,adult,teen,child;
    EditText e1,e2,e3;
    Switch startswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        setTitle("레스토랑 예약시스템");
        prevbtn = (Button)findViewById(R.id.prevb);
        nextbtn = (Button)findViewById(R.id.nextb);
        dp = (DatePicker)findViewById(R.id.datePicker);
        tp = (TimePicker)findViewById(R.id.timePicker);

    }





}
