package com.example.contactdatabase;

public class CourseModal {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String hikeName;
    private String hikeLocation;
    private String hikeDate;
    private String hikeParking;
    private String hikeLength;
    private String hikeLevel;

    private String hikeDescription;
    private int id;

    // creating getter and setter methods
    public String getHikeName() { return hikeName; }

    public void setHikeName(String courseName)
    {
        this.hikeName = hikeName;
    }

    public String getHikeLocation()
    {
        return hikeLocation;
    }

    public void setHikeLocation(String courseDuration)
    {
        this.hikeLocation = hikeLocation;
    }

    public String getHikeDate() { return hikeDate; }

    public void setHikeDate(String courseTracks)
    {
        this.hikeDate = hikeDate;
    }
    public String getHikeParking() { return hikeParking; }

    public void setHikeParking(String hikeParking)
    {
        this.hikeParking = hikeParking;
    }
    public String getHikeLength() { return hikeLength; }

    public void setHikeLength(String hikeLength)
    {
        this.hikeLength = hikeLength;
    }
    public String getHikeLevel() { return hikeLevel; }

    public void setHikeLevel(String hikeLevel)
    {
        this.hikeLevel = hikeLevel;
    }

    public String getHikeDescription()
    {
        return hikeDescription;
    }

    public void
    setHikeDescription(String hikeDescription)
    {
        this.hikeDescription = hikeDescription;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public CourseModal(String hikeName,
                       String hikeLocation,
                       String hikeDate,
                       String hikeParking,
                       String hikeLength,
                       String hikeLevel,
                       String hikeDescription)
    {
        this.hikeName = hikeName;
        this.hikeLocation = hikeLocation;
        this.hikeDate = hikeDate;
        this.hikeParking = hikeParking;
        this.hikeLength = hikeLength;
        this.hikeLevel = hikeLevel;
        this.hikeDescription = hikeDescription;
    }
}
