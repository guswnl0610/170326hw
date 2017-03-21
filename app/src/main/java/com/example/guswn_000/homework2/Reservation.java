package com.example.guswn_000.homework2;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Reservation extends AppCompatActivity {

    Button prevbtn,nextbtn;
    DatePicker dp;
    TimePicker tp;
    GridLayout glayout,glayout2;
    TextView timertv,date,time,adult,teen,child;
    EditText e1,e2,e3;
    Switch startswitch;
    int page = 0;
    int tt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        setTitle("레스토랑 예약시스템");
        prevbtn = (Button)findViewById(R.id.prevb);
        nextbtn = (Button)findViewById(R.id.nextb);
        dp = (DatePicker)findViewById(R.id.datePicker);
        tp = (TimePicker)findViewById(R.id.timePicker);
        glayout = (GridLayout)findViewById(R.id.grdlayout1);
        glayout2 = (GridLayout)findViewById(R.id.gridlayout2);
        timertv = (TextView)findViewById(R.id.timer);
        date = (TextView)findViewById(R.id.datetv);
        time = (TextView)findViewById(R.id.timetv);
        adult = (TextView)findViewById(R.id.adulttv);
        teen = (TextView)findViewById(R.id.teentv);
        child = (TextView)findViewById(R.id.childtv);
        e1 = (EditText)findViewById(R.id.edtadult);
        e2 = (EditText)findViewById(R.id.edtteen);
        e3 = (EditText)findViewById(R.id.edtchild);
        startswitch = (Switch)findViewById(R.id.switch1);
        mHandler.sendEmptyMessage(1);

        startswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(startswitch.isChecked())
                {
                    tt = 0;
                    page = 0;
                    prevbtn.setVisibility(View.VISIBLE);
                    nextbtn.setVisibility(View.VISIBLE);
                    dp.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.INVISIBLE);
                    glayout.setVisibility(View.INVISIBLE);
                    glayout2.setVisibility(View.INVISIBLE);
                    timertv.setVisibility(View.VISIBLE);
                    prevbtn.setEnabled(false);
                    nextbtn.setEnabled(true);
                    Calendar cal;
                    cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int min = cal.get(Calendar.MINUTE);
                    dp.updateDate(year,month,day);
                    tp.setCurrentHour(hour);
                    tp.setCurrentMinute(min);
                }
                else
                {
                    tt = 0;
                    timertv.setVisibility(View.INVISIBLE);
                    page = 0;
                    date.setText("년 월 일");
                    time.setText("시 분");
                    adult.setText("명");
                    teen.setText("명");
                    child.setText("명");

                    e1.setText(null);
                    e2.setText(null);
                    e3.setText(null);
                    prevbtn.setVisibility(View.INVISIBLE);
                    nextbtn.setVisibility(View.INVISIBLE);
                    glayout.setVisibility(View.INVISIBLE);
                    glayout2.setVisibility(View.INVISIBLE);
                    dp.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.INVISIBLE);
                }
            }
        });
        dp.init(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText(year+"년 "+(monthOfYear+1)+"월 "+dayOfMonth+"일");
            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay+"시 "+minute+"분");
            }
        });

    }

    Handler mHandler = new Handler()
    {
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            int div = msg.what;
            int min = tt / 60;
            int sec = tt % 60;
            String strTime = String.format("%02d : %02d", min, sec);

            this.sendEmptyMessageDelayed(0, 1000);
            timertv.setText(strTime);
            timertv.invalidate();
            tt++;

        }
    };


    public void mengbutton(View v)
    {
        switch(v.getId())
        {
            case R.id.prevb:
                if(page > 0)
                {
                    page--;
                }
                changepage();
                break;
            case R.id.nextb:
                if(page < 4)
                {
                    page++;
                }
                changepage();
                break;
            default:
                break;
        }
    }
    public void changepage()
    {
        if(page == 0)
        {
            dp.setVisibility(View.VISIBLE);
            tp.setVisibility(View.INVISIBLE);
            glayout.setVisibility(View.INVISIBLE);
            glayout2.setVisibility(View.INVISIBLE);
            prevbtn.setEnabled(false);
            nextbtn.setEnabled(true);
        }
        if(page == 1)
        {
            dp.setVisibility(View.INVISIBLE);
            tp.setVisibility(View.VISIBLE);
            glayout.setVisibility(View.INVISIBLE);
            glayout2.setVisibility(View.INVISIBLE);
            prevbtn.setEnabled(true);
            nextbtn.setEnabled(true);
        }
        if(page == 2)
        {
            dp.setVisibility(View.INVISIBLE);
            tp.setVisibility(View.INVISIBLE);
            glayout.setVisibility(View.VISIBLE);
            glayout2.setVisibility(View.INVISIBLE);
            prevbtn.setEnabled(true);
            nextbtn.setEnabled(true);
        }
        if(page == 3)
        {
            dp.setVisibility(View.INVISIBLE);
            tp.setVisibility(View.INVISIBLE);
            glayout.setVisibility(View.INVISIBLE);
            glayout2.setVisibility(View.VISIBLE);
            prevbtn.setEnabled(true);
            nextbtn.setEnabled(false);
            adult.setText(e1.getText().toString()+"명");
            teen.setText(e2.getText().toString()+"명");
            child.setText(e3.getText().toString()+"명");
        }
    }





}
