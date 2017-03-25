package com.haven.hotels.hotelshaven;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final Context context = this;
    private EditText destination, checkinDate, checkoutDate;
    private DatePickerDialog checkinDatePickerDialog, checkoutDatePickerDialog;
    private Spinner adultSpinner, childrenSpinner, roomSpinner;
    private String destinationText, checkinText, checkoutText, adultText, childrenText, roomText;

    private SimpleDateFormat dateFormatter;
    private Calendar newDate, checkin, checkout;
    DataValidation dataValidation = new DataValidation();

    private Button findHotels;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd MMM yy", Locale.US);


        findViewsById();

        setDateTimeField();

        getDataFromApp();


        findHotels.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(dataValidation.isEmpty(destinationText))
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Destination");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Did you forget to enter a destination?")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    //MainActivity.this.finish();
                                    dialog.cancel();
                                }
                            }) ;

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
            }
        });




    }


    private void findViewsById()
    {
        destination = (EditText) findViewById(R.id.destinationedittext);

        checkinDate = (EditText) findViewById(R.id.checkinDate);
        checkinDate.setInputType(InputType.TYPE_NULL);
        checkinDate.setText(dateFormatter.format(new Date()));

        checkoutDate = (EditText) findViewById(R.id.checkoutDate);
        checkoutDate.setInputType(InputType.TYPE_NULL);
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DATE, 1);
        checkoutDate.setText(dateFormatter.format(newDate.getTime()));

        adultSpinner = (Spinner) findViewById(R.id.adultSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.adultGuestArray, R.layout.spinnertext);
        adultSpinner.setAdapter(adapter);

        childrenSpinner = (Spinner) findViewById(R.id.childrenSpinner);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.childrenGuestArray, R.layout.spinnertext);
        childrenSpinner.setAdapter(adapter1);

        roomSpinner = (Spinner) findViewById(R.id.roomSpinner);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.roomArray, R.layout.spinnertext);
        roomSpinner.setAdapter(adapter2);

        findHotels = (Button) findViewById(R.id.findhotels);
    }

    private void setDateTimeField() {
        checkinDate.setOnClickListener(this);
        checkoutDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        checkinDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                checkin = Calendar.getInstance();
                checkin.set(year, monthOfYear, dayOfMonth);
                checkinDate.setText(dateFormatter.format(checkin.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        checkoutDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                checkout = Calendar.getInstance();
                checkout.set(year, monthOfYear, dayOfMonth);
                checkoutDate.setText(dateFormatter.format(checkout.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == checkinDate) {
            checkinDatePickerDialog.show();
        } else if(view == checkoutDate) {
            checkoutDatePickerDialog.show();
        }
    }


    private void getDataFromApp()
    {
        destinationText = destination.getText().toString();
        checkinText = checkinDate.getText().toString();
        checkoutText = checkoutDate.getText().toString();
        adultText = adultSpinner.getSelectedItem().toString();
        childrenText = childrenSpinner.getSelectedItem().toString();
        roomText = roomSpinner.getSelectedItem().toString();
    }




}
