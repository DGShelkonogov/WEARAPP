package com.example.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    Button alarm_button;
    Handler handler = new Handler();
    Random random = new Random();
    String[] messages =  {"Еще", "Давай еще", "Чуть чуть осталось", "ДА"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        alarm_button = binding.alarmButton;

        alarm_button.setOnClickListener(view -> {
            if(random.nextBoolean()){
                int index = rnd(0, messages.length-1);
                alarm_button.setText(messages[index]);
            }else{
                alarm_button.setText("Кто нажал тот лох");
                handler.postDelayed(timerRunnable, 3000);
            }
        });
    }

    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            alarm_button.setText("Умница");
        }
    };

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}