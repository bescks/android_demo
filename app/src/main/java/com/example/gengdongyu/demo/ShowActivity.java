package com.example.gengdongyu.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        int cinema = intent.getIntExtra("CINEMA", 0);
        int showing = intent.getIntExtra("SHOWING", 0);
        TextView tv1 = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);
        if(showing==-1){
            setTitle("电影院 "+cinema);
            switch (cinema){
                case 1:
                    tv1.setText("场次 1");
                    tv2.setText("场次 2");
                    tv3.setText("");
                    tv4.setText("");
                    break;
                case 2:
                    tv1.setText("场次 2");
                    tv2.setText("场次 3");
                    tv3.setText("");
                    tv4.setText("");
                    break;
                case 3:
                    tv1.setText("场次 1");
                    tv2.setText("场次 3");
                    tv3.setText("");
                    tv4.setText("");
                    break;
                case 4:
                    tv1.setText("场次 1");
                    tv2.setText("场次 2");
                    tv3.setText("场次 3");
                    tv4.setText("场次 4");
                    break;

            }}
        if(cinema==-1){
            setTitle("场次 "+showing);
            switch (showing){
                case 1:
                    tv1.setText("电影院 1");
                    tv2.setText("电影院 3");
                    tv3.setText("电影院 4");
                    tv4.setText("");
                    break;
                case 2:
                    tv1.setText("电影院 1");
                    tv2.setText("电影院 2");
                    tv3.setText("电影院 4");
                    tv4.setText("");
                    break;
                case 3:
                    tv1.setText("电影院 2");
                    tv2.setText("电影院 3");
                    tv3.setText("电影院 4");
                    tv4.setText("");
                    break;
            }}

    }
}
