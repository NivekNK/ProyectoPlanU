package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;

public class Manager 
{
    private String rut;
    private int age;
    private String name;
    private String job;
    
    private ArrayList<ActivityKey> managedActivities;
    
    public Manager(String rut, int age, String name)
    {
        this.rut = rut;
        this.age = age;
        this.name = name;
        managedActivities = new ArrayList();
    }
    
    public void addManagedActivity(Activity activity)
    {
        managedActivities.add(new ActivityKey(activity.getName(), activity.getDate()));
    }
    
    public void addManagedActivity(String activityName, String activityDate)
    {
        managedActivities.add(new ActivityKey(activityName, activityDate));
    }
    
    public boolean removeActivity(Activity activity)
    {
        return managedActivities.remove(new ActivityKey(activity.getName(), activity.getDate()));
    }
    
    public boolean removeActivity(String activityName, String activityDate)
    {
        return managedActivities.remove(new ActivityKey(activityName, activityDate));
    }
    
    public ArrayList<ActivityKey> getManagedActivities() { return managedActivities; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getJob() {return job; }
    public String getRut() {return rut; }
    
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setJob(String job) {this.job = job; }
    public void setRut(String rut) {this.rut = rut; }
}
