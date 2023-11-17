package com.example.contactdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText hikeNameEdt, hikeLocationEdt, hikeDateEdt, hikeParkingEdt,hikeLengthEdt,hikeLevelEdt,hikeDescriptionEdt;
    private Button addHikeBtn, readHikeBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        hikeNameEdt = findViewById(R.id.idEdtHikeName);
        hikeLocationEdt = findViewById(R.id.idEdtHikeLocation);
        hikeDateEdt = findViewById(R.id.idEdtHikeDate);
        hikeParkingEdt = findViewById(R.id.idEdtHikeParking);
        hikeLengthEdt = findViewById(R.id.idEdtHikeLength);
        hikeLevelEdt = findViewById(R.id.idEdtHikeLevel);
        hikeDescriptionEdt = findViewById(R.id.idEdtHikeDescription);
        addHikeBtn = findViewById(R.id.idBtnAddHike);
        readHikeBtn = findViewById(R.id.idBtnReadHike);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addHikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String hikeName = hikeNameEdt.getText().toString();
                String hikeLocation = hikeLocationEdt.getText().toString();
                String hikeDate = hikeDateEdt.getText().toString();
                String hikeParking = hikeParkingEdt.getText().toString();
                String hikeLength = hikeLengthEdt.getText().toString();
                String hikeLevel = hikeLevelEdt.getText().toString();
                String hikeDescription = hikeDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (hikeName.isEmpty() || hikeLocation.isEmpty() || hikeDate.isEmpty() || hikeParking.isEmpty() || hikeLength.isEmpty() || hikeLevel.isEmpty() || hikeDescription.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewHike(hikeName, hikeLocation, hikeDate, hikeParking, hikeLength, hikeLevel, hikeDescription);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                hikeNameEdt.setText("");
                hikeLocationEdt.setText("");
                hikeDateEdt.setText("");
                hikeParkingEdt.setText("");
                hikeLengthEdt.setText("");
                hikeLevelEdt.setText("");
                hikeDescriptionEdt.setText("");
            }
        });

        readHikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });
    }
}