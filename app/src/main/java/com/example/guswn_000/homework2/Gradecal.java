package com.example.guswn_000.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gradecal extends AppCompatActivity
{
    Button cal,res;
    TextView total,average;
    EditText e1,e2,e3;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradecal);
        setTitle("학점 계산기");
        cal = (Button)findViewById(R.id.calb);
        res = (Button)findViewById(R.id.resetb);
        total = (TextView)findViewById(R.id.totaltv);
        average = (TextView)findViewById(R.id.averagetv);
        image = (ImageView)findViewById(R.id.imageView);
        e1 = (EditText)findViewById(R.id.koret);
        e2 = (EditText)findViewById(R.id.mathet);
        e3 = (EditText)findViewById(R.id.enget);
    }

    public void mylistener(View v)
    {
        if(v.getId() == R.id.calb)
        {
            emptytozero();
            calculate();
        }
        else if(v.getId() == R.id.resetb)
        {
            image.setVisibility(View.GONE);
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            total.setText("0점");
            average.setText("0점");
            Toast.makeText(getApplicationContext(),"초기화되었습니다.",Toast.LENGTH_SHORT).show();
        }

    }

    public void calculate()
    {

        String korscore = e1.getText().toString();
        String mathscore = e2.getText().toString();
        String engscore = e3.getText().toString();
        int totalscore = Integer.parseInt(korscore) + Integer.parseInt(mathscore) + Integer.parseInt(engscore);
        double averagescore = totalscore / 3;
        total.setText(totalscore + "점");
        average.setText(averagescore + "점");
        if(averagescore >= 90)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.a); // 이미지를 a 로 세팅
        }
        else if(averagescore >= 80)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.b);
        }
        else if(averagescore >= 70)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.c);
        }
        else if(averagescore >= 60)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.d);
        }
        else
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.f);
        }


    }

    public void emptytozero()
    {
        if(e1.getText().toString().replace(" ","").equals(""))
        {
            e1.setText("0");
        }
        if(e2.getText().toString().replace(" ","").equals(""))
        {
            e2.setText("0");
        }
        if(e3.getText().toString().replace(" ","").equals(""))
        {
            e3.setText("0");
        }
        if(e1.getText().toString().replace(" ","").equals("") && e2.getText().toString().replace(" ","").equals(""))
        {
            e1.setText("0");
            e2.setText("0");
        }
        if (e2.getText().toString().replace(" ","").equals("") && e3.getText().toString().replace(" ","").equals(""))
        {
            e2.setText("0");
            e3.setText("0");
        }
        if(e1.getText().toString().replace(" ","").equals("") && e3.getText().toString().replace(" ","").equals(""))
        {
            e1.setText("0");
            e3.setText("0");
        }
        if (e1.getText().toString().replace(" ","").equals("") && e2.getText().toString().replace(" ","").equals("") && e3.getText().toString().replace(" ","").equals(""))
        {
            e1.setText("0");
            e2.setText("0");
            e3.setText("0");
        }
    }


}
