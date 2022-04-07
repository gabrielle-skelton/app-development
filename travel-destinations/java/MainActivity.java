package com.example.lesson5countrylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    String[] countryList = {
            "India", "China", "Australia", "America", "New Zealand"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView countryListView = findViewById(R.id.countryListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.country_name, countryList);
        countryListView.setAdapter(arrayAdapter);
    }
}