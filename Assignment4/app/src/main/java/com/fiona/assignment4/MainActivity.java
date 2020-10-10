package com.fiona.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SeekBar red,green,blue;
TextView colorbar,r,g,b;
int colorR=0,colorB=0,colorG=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorbar = findViewById(R.id.colorbar);
        red= findViewById(R.id.red);
        green=findViewById(R.id.green);
        blue=findViewById(R.id.blue);
        r=findViewById(R.id.redAmt);
        g=findViewById(R.id.greenAmt);
        b=findViewById(R.id.blueAmt);
        colorbar.setBackgroundColor(Color.argb(255,colorR,colorG,colorB));
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                colorR = i;
                r.setText(i+"");
                colorbar.setBackgroundColor(Color.argb(255,i,colorG,colorB));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                colorG=i;
                g.setText(i+"");
                colorbar.setBackgroundColor(Color.argb(255,colorR,i,colorB));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                colorB=i;
                b.setText(i+"");
                colorbar.setBackgroundColor(Color.argb(255,colorR,colorG,i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
