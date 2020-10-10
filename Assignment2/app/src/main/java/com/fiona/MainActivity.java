package com.fiona;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    int[][] songs_details = {
            {(R.raw.across_the_lines), (R.string.across_the_lines)},
            {(R.raw.ariana_grande_break_free), (R.string.break_free)},
            {(R.raw.kryptonite_3_doors_down), (R.string.kryptonite)},
            {(R.raw.avicii_hey_brother), (R.string.hey_brother)},
            {(R.raw.adele_chasing_pavements), (R.string.chasing_pavements)},
            {(R.raw.bastille_pompeii), (R.string.pompeii)},
            {(R.raw.bruce_springsteen_hungry_heart), (R.string.hungry_heart)},
            {(R.raw.good_girls_5_seconds_of_summer), (R.string.good_girls)},
            {(R.raw.calvin_harris_summer), (R.string.summer)}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] songsNames= {
                getResources().getString(R.string.across_the_lines),
                getResources().getString(R.string.break_free),
                getResources().getString(R.string.kryptonite),
                getResources().getString(R.string.hey_brother),
                getResources().getString(R.string.chasing_pavements),
                getResources().getString(R.string.pompeii),
                getResources().getString(R.string.hungry_heart),
                getResources().getString(R.string.good_girls),
                getResources().getString(R.string.summer)
        };

        ListView songsList = findViewById(R.id.songList);
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this, R.layout.song ,songsNames);
        songsList.setAdapter(adapt);

        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView= (TextView) view;
                Intent i;
                String str = textView.getText().toString();
                if(str.equalsIgnoreCase(getString(R.string.across_the_lines))){

                }else if(str.equalsIgnoreCase(getString(R.string.break_free))){
                }else if(str.equalsIgnoreCase(getString(R.string.kryptonite))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.hey_brother))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.hungry_heart))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.summer))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.good_girls))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.chasing_pavements))){
                }
                else if(str.equalsIgnoreCase(getString(R.string.pompeii))){
                }

            }
        });
    }
}
