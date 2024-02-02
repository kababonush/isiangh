package com.isac.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public abstract class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, DialogInterface.OnClickListener {

    boolean isSubmit;

    public void clickMainButtonDate(View view){
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dateDialog = new DatePickerDialog(this, this,
                currentYear, currentMonth, currentDay);
        dateDialog.show();
    }
    public void clickMainButtonTime(View view){
        Calendar currentCalendar = Calendar.getInstance();
        int currentHour = currentCalendar.get(Calendar.HOUR);
        int currentMinute = currentCalendar.get(Calendar.MINUTE);
        TimePickerDialog timeDialog = new TimePickerDialog(this, this,
                currentHour, currentMinute, true);
        timeDialog.show();
    }
    AlertDialog dialog;
    public  void clickMainButtonAlert(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Question");
        builder.setMessage("What is the baby's gender?");
        builder.setPositiveButton("Male",this);
        builder.setNegativeButton("Female",this);

        dialog = builder.create();
        builder.show();
    }
    public  void clickMainButtonSubmit(View view){
        isSubmit = true;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Question");
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Indeed",this);
        builder.setNegativeButton("nahhh",this);

        dialog = builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isSubmit = false;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + "-" + month + "-" + year;
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
    @Override
    public void onClick(DialogInterface dialogInterface, int btn){
        if(isSubmit){
            if (btn == dialog.BUTTON_POSITIVE){
                Toast.makeText(this,);
            }
        }
        isSubmit = false;
    }

}