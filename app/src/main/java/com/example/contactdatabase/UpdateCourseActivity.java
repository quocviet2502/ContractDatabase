package com.example.contactdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourseActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText hikeNameEdt, hikeLocationEdt, hikeDateEdt, hikeParkingEdt,hikeLengthEdt,hikeLevelEdt,hikeDescriptionEdt;
    private Button updateHikeBtn, deleteHikeBtn;
    private DBHandler dbHandler;
    String hikeName, hikeLocation, hikeDate, hikeParking,hikeLength,hikeLevel,hikeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        // initializing all our variables.
        hikeNameEdt = findViewById(R.id.idEdtHikeName);
        hikeLocationEdt = findViewById(R.id.idEdtHikeLocation);
        hikeDateEdt = findViewById(R.id.idEdtHikeDate);
        hikeParkingEdt = findViewById(R.id.idEdtHikeParking);
        hikeLengthEdt = findViewById(R.id.idEdtHikeLength);
        hikeLevelEdt = findViewById(R.id.idEdtHikeLevel);
        hikeDescriptionEdt = findViewById(R.id.idEdtHikeDescription);
        updateHikeBtn = findViewById(R.id.idBtnUpdateHike);
        deleteHikeBtn = findViewById(R.id.idBtnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateCourseActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        hikeName = getIntent().getStringExtra("name");
        hikeLocation = getIntent().getStringExtra("location");
        hikeDate = getIntent().getStringExtra("date");
        hikeParking = getIntent().getStringExtra("parking");
        hikeLength = getIntent().getStringExtra("length");
        hikeLevel = getIntent().getStringExtra("level");
        hikeDescription = getIntent().getStringExtra("description");
        // setting data to edit text
        // of our update activity.
        hikeNameEdt.setText(hikeName);
        hikeLocationEdt.setText(hikeLocation);
        hikeDateEdt.setText(hikeDate);
        hikeParkingEdt.setText(hikeParking);
        hikeLengthEdt.setText(hikeLength);
        hikeLevelEdt.setText(hikeLevel);
        hikeDescriptionEdt.setText(hikeDescription);

        // adding on click listener to our update course button.
        updateHikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateHike(hikeName, hikeNameEdt.getText().toString(), hikeLocationEdt.getText().toString(), hikeDateEdt.getText().toString(), hikeParkingEdt.getText().toString(),hikeLengthEdt.getText().toString(),hikeLevelEdt.getText().toString(),hikeDescriptionEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateCourseActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        deleteHikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteCourse(hikeName);
                Toast.makeText(UpdateCourseActivity.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}