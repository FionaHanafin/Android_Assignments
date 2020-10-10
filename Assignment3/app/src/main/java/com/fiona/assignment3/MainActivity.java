package com.fiona.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private int[] picsList = {
            R.drawable.pup1, R.drawable.pup2, R.drawable.pup3,
            R.drawable.pup4, R.drawable.pup5, R.drawable.pup6,
            R.drawable.pup7, R.drawable.pup8, R.drawable.pup9,
            R.drawable.pup10
    };
    private ImageView image_2;
    private ToggleButton slideshow_btn;
    RelativeLayout rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set variables
        image_2 = findViewById(R.id.image);
        //set first image and content description
        image_2.setImageResource(picsList[0]);
        image_2.setContentDescription("0");
        rel = findViewById(R.id.rel);
        slideshow_btn = findViewById(R.id.start_slideshow);
        //ensure slideshow button is off
        slideshow_btn.setChecked(false);


    }

    public void Previous(View v) {
        int picNum = Integer.parseInt(image_2.getContentDescription().toString());
        if (picNum == 0) {
            image_2.setImageResource(picsList[9]);
            image_2.setContentDescription("9");
        } else {
            image_2.setImageResource(picsList[picNum - 1]);
            image_2.setContentDescription("" + (picNum - 1));
        }
    }

    public void Next(View v) {
        int picNum = Integer.parseInt(image_2.getContentDescription().toString());
        if (picNum == 9) {
            image_2.setImageResource(picsList[0]);
            image_2.setContentDescription("0");
        } else {
            image_2.setImageResource(picsList[picNum + 1]);
            image_2.setContentDescription("" + (picNum + 1));
        }
    }

    public void StartSlideshow(View v) {
        //define the animations
        final Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        final Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        //if toggle is on then set background color
        if (slideshow_btn.isChecked()) {
            rel.setBackgroundColor(getColor(R.color.slideshow_background));
            //offset the first animation
            animation1.setStartOffset(3000);
            //start the animation
            image_2.startAnimation(animation1);
            //Set listner to change image when animation finishes
            animation1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation arg0) {
//                  get content description(index of the array) let it equal an integer
                    int i = Integer.parseInt(image_2.getContentDescription().toString());
                    //if the toggle is on start the animation and set next i
                    if (slideshow_btn.isChecked()) {
                        //start the animation and set next picture
                        image_2.startAnimation(animation2);
                        if (i == 9) {
                            image_2.setContentDescription("0");
                            image_2.setImageResource(picsList[0]);
                        } else {
                            image_2.setContentDescription("" + (i + 1));
                            image_2.setImageResource(picsList[i + 1]);
                        }
                    }
                }

                @Override
                public void onAnimationRepeat(Animation arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationStart(Animation arg0) {
                    // TODO Auto-generated method stub
                }
            });
            animation2.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationEnd(Animation arg0) {
                    // if toggle button is on then start animation with 3 second delay
                    if (slideshow_btn.isChecked()) {
                        animation1.setStartOffset(3000);
                        image_2.startAnimation(animation1);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationStart(Animation arg0) {
                    // TODO Auto-generated method stub
                }
            });
        } else {
            clearAnimation();//clear the animation set the image and content description and reset background color
        }
    }

    private void clearAnimation() {
        //clear the animation set the image and content description and reset background color
        image_2.clearAnimation();
        image_2.setContentDescription(image_2.getContentDescription().toString());
        image_2.setImageResource(picsList[Integer.parseInt(image_2.getContentDescription().toString())]);
        rel.setBackgroundColor(getColor(R.color.background));
    }
}
