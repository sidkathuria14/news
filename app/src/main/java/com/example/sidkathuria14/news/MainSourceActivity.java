package com.example.sidkathuria14.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainSourceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner country_spinner,language_spinner,category_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_source);

        country_spinner = (Spinner)findViewById(R.id.country_spinner);
        language_spinner = (Spinner)findViewById(R.id.language_spinner);
        category_spinner  = (Spinner)findViewById(R.id.category_spinner);



        country_spinner.setOnItemSelectedListener(this);
        category_spinner.setOnItemSelectedListener(this);
        language_spinner.setOnItemSelectedListener(this);

        String country_array[] = {"choose country","au","de","gb","in","it","us"};
String language_array[] = {"choose language","en","de","fr"};
        String category_array[] = {"choose category","business", "entertainment", "gaming", "general", "music",
                "politics", "science-and-nature", "sport", "technology"};

        ArrayAdapter country_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country_array);
        ArrayAdapter language_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,language_array);
        ArrayAdapter category_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category_array);

        country_spinner.setAdapter(country_adapter);
        language_spinner.setAdapter(language_adapter);
        category_spinner.setAdapter(category_adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "selected: " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
