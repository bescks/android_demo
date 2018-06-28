package com.example.gengdongyu.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinner_cinemas;
    Spinner spinner_showings;
    ArrayAdapter<CharSequence> adapter_cinemas;
    ArrayAdapter<CharSequence> adapter_showings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_cinemas = (Spinner) findViewById(R.id.spinner_cinemas);
        adapter_cinemas = ArrayAdapter.createFromResource(this, R.array.cinemas, android.R.layout.simple_spinner_item);
        adapter_cinemas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cinemas.setAdapter(adapter_cinemas);
        spinner_cinemas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((parent.getItemIdAtPosition(position) == 0)) return;
//                Toast.makeText(getBaseContext(), adapter_cinemas.getItem((int) parent.getItemIdAtPosition(position)) + " selected", Toast.LENGTH_SHORT).show();
//                spinner_cinemas.setSelection(0);
                openShowActiveity((int) parent.getItemIdAtPosition(position), -1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_showings = (Spinner) findViewById(R.id.spinner_showings);
        adapter_showings = ArrayAdapter.createFromResource(this, R.array.showings, android.R.layout.simple_spinner_item);
        adapter_showings.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_showings.setAdapter(adapter_showings);
        spinner_showings.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((parent.getItemIdAtPosition(position) == 0)) return;
//                Toast.makeText(getBaseContext(), adapter_showings.getItem((int) parent.getItemIdAtPosition(position)) + " selected", Toast.LENGTH_SHORT).show();
                spinner_showings.setSelection(0);
                openShowActiveity(-1, (int) parent.getItemIdAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void openShowActiveity(int cinema, int showing) {
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        System.out.println(cinema + "        " + showing);
        intent.putExtra("CINEMA", cinema);
        intent.putExtra("SHOWING", showing);
        startActivityForResult(intent,1);
    }
}
