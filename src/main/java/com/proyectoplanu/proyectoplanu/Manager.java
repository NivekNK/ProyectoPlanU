package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;

public class Manager extends Person
{
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
        managedActivities.add(new ActivityKey(activity.getName(), activity.getDate(), activity.getHour()));
    }
    
    public void addManagedActivity(String activityName, String activityDate, float activityHour)
    {
        managedActivities.add(new ActivityKey(activityName, activityDate, activityHour));
    }
    
    public boolean removeActivity(Activity activity)
    {
        return managedActivities.remove(new ActivityKey(activity.getName(), activity.getDate(), activity.getHour()));
    }
    
    public boolean removeActivity(String activityName, String activityDate, float hour)
    {
        return managedActivities.remove(new ActivityKey(activityName, activityDate, hour));
    }
    
    public ArrayList<ActivityKey> getManagedActivities() { return managedActivities; }
}
