package com.example.guswn_000.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 메뉴");
    }
    public void menutoother(View v)
    {
        if(v.getId() == R.id.gotorelativelayout)
        {
            Intent intent = new Intent(MainActivity.this, Relative.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.gotogradecalculator)
        {
            Intent intent = new Intent(MainActivity.this, Gradecal.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.gotoreservation)
        {
            Intent intent = new Intent(MainActivity.this, Reservation.class);
            startActivity(intent);
        }
    }

}
