package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;

public class Activity 
{
    private String date;
    private float hour;
    private String nameActivity;
    
    private ArrayList<Student> students;
    private Manager manager;
    
    public Activity()
    {
        date = "01-01-2022";
        hour = 08.00f;
        nameActivity = "Presentarse";
        students = new ArrayList();
        manager = new Manager();
    }
    
    public String getDate() { return date; }
    public float getHour() { return hour; }
    public String getNameActivity() { return nameActivity; }
    public Manager getManager() { return manager; }
    
    public void setDate(String date) { this.date = date; } 
    public void setHour(float hour) { this.hour = hour; }
    public void setNameActivity(String nameActivity) { this.nameActivity = nameActivity; }
    public void setManager(Manager manager) { this.manager = manager; }
}
