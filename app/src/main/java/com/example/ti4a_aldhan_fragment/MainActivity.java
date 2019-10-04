package com.example.ti4a_aldhan_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public  class MainActivity extends AppCompatActivity {
    FrameLayout frameOne,frameTwo,frameThree;

    int frameOneIndex = 0;
    int frameTwoIndex = 1;
    int frameThreeIndex = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameOne = findViewById(R.id.frameOne);
        frameTwo = findViewById(R.id.frameTwo);
        frameThree = findViewById(R.id.frameThree);

        loadFragment(R.id.frameOne,new FragmentOne());
        loadFragment(R.id.frameTwo,new FragmentTwo());
        loadFragment(R.id.frameThree,new FragmentThree());

        frameOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                frameOneIndex++;
                if(frameOneIndex == 3){
                    frameOneIndex = 0;
                }
                switch (frameOneIndex){
                    case 0:
                        loadFragment(R.id.frameOne,new FragmentOne());
                        break;
                    case 1:
                        loadFragment(R.id.frameOne,new FragmentTwo());
                        break;
                    case 2:
                        loadFragment(R.id.frameOne,new FragmentThree());
                        break;
                }
            }
        });

        frameTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                frameTwoIndex++;
                if(frameTwoIndex == 3){
                    frameTwoIndex = 0;
                }
                switch (frameTwoIndex){
                    case 0:
                        loadFragment(R.id.frameTwo,new FragmentOne());
                        break;
                    case 1:
                        loadFragment(R.id.frameTwo,new FragmentTwo());
                        break;
                    case 2:
                        loadFragment(R.id.frameTwo,new FragmentThree());
                        break;
                }
            }
        });

        frameThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                frameThreeIndex++;
                if(frameThreeIndex == 3){
                    frameThreeIndex = 0;
                }

                switch (frameThreeIndex){
                    case 0:
                        loadFragment(R.id.frameThree,new FragmentOne());
                        break;
                    case 1:
                        loadFragment(R.id.frameThree,new FragmentTwo());
                        break;
                    case 2:
                        loadFragment(R.id.frameThree,new FragmentThree());
                        break;

                }
            }
        });
    }

    public void loadFragment (int target,Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(target,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}