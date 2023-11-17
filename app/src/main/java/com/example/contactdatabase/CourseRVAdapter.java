package com.example.contactdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<CourseModal> courseModalArrayList;
    private Context context;

    // constructor
    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CourseModal modal = courseModalArrayList.get(position);
        holder.hikeNameTV.setText(modal.getHikeName());
        holder.hikeLocationTV.setText(modal.getHikeLocation());
        holder.hikeDateTV.setText(modal.getHikeDate());
        holder.hikeParingTV.setText(modal.getHikeParking());
        holder.hikeLengthTV.setText(modal.getHikeLength());
        holder.hikeLevelTV.setText(modal.getHikeLevel());
        holder.hikeDescriptionTV.setText(modal.getHikeDescription());


        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateCourseActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getHikeName());
                i.putExtra("location", modal.getHikeLocation());
                i.putExtra("date", modal.getHikeDate());
                i.putExtra("parking", modal.getHikeParking());
                i.putExtra("length", modal.getHikeLength());
                i.putExtra("level", modal.getHikeLevel());
                i.putExtra("description", modal.getHikeDescription());


                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView hikeNameTV, hikeLocationTV, hikeDateTV, hikeParingTV,hikeLengthTV,hikeLevelTV,hikeDescriptionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            hikeNameTV = itemView.findViewById(R.id.idTVHikeName);
            hikeLocationTV = itemView.findViewById(R.id.idTVHikeLocation);
            hikeDateTV = itemView.findViewById(R.id.idTVHikeDate);
            hikeParingTV = itemView.findViewById(R.id.idTVHikeParking);
            hikeLengthTV = itemView.findViewById(R.id.idTVHikeLength);
            hikeLevelTV = itemView.findViewById(R.id.idTVHikeLevel);
            hikeDescriptionTV = itemView.findViewById(R.id.idTVHikeDescription);
        }
    }
}