package com.example.projetamio;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent startService ;

    int buttonState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        buttonState=1;
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        boolean pref=sharedPref.getBoolean("check_box_preference_1",false);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Création de l'activité");
        startService = new Intent(this, MainService.class);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView text =findViewById(R.id.textView2);

                if(isChecked){
                    text.setText("en cours");}
                else{
                    text.setText("arrêté");
                }
            }
        });
        Switch switch3 =  findViewById(R.id.switch3);
        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonState==1){

                LinearLayout linearLayout1= findViewById(R.id.linearLayout);
                linearLayout1.setVisibility(View.GONE);
                LinearLayout linearLayout2=findViewById(R.id.linearLayout2);
                linearLayout2.setVisibility(View.GONE);
                Switch switch3 = findViewById(R.id.switch3);
                switch3.setVisibility(View.GONE);
                buttonState=0;
                    Button button =  findViewById(R.id.button);
                    button.setText("Main Menu");
                    FragmentContainerView Fragment2= findViewById(R.id.fragmentContainerView);
                    Fragment2.setVisibility(View.VISIBLE);
                }
                else{
                    LinearLayout linearLayout1 =  findViewById(R.id.linearLayout);
                    linearLayout1.setVisibility(View.VISIBLE);
                    LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
                    linearLayout2.setVisibility(View.VISIBLE);
                    Switch switch3 = findViewById(R.id.switch3);
                    switch3.setVisibility(View.VISIBLE);
                    buttonState = 1;
                    Button button =  findViewById(R.id.button);
                    button.setText("Preferences");
                    FragmentContainerView Fragment2= findViewById(R.id.fragmentContainerView);
                    Fragment2.setVisibility(View.GONE);
                }}
        });

        switch3.setChecked(pref);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}