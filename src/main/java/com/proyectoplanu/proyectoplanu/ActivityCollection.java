package com.proyectoplanu.proyectoplanu;

import java.util.HashMap;
import java.util.ArrayList;

public class ActivityCollection
{
    private HashMap<ActivityKey, Activity> activitiesByKey;

    public ActivityCollection()
    {
        activitiesByKey = new HashMap();
    }
    
    public ArrayList<Activity> getAllActivities()
    {
        ArrayList<Activity> activities = new ArrayList();
        activitiesByKey.entrySet().forEach(entry -> 
        {
            Activity activity = entry.getValue();
            activities.add(activity);
        });
        return activities;
    }
    
    // No es un getter
    public Activity getActivity(String name, String date)
    {
        return getActivity(new ActivityKey(name, date));
    }
    
    // No es un getter
    public Activity getActivity(ActivityKey activityKey)
    {
        return activitiesByKey.get(activityKey);
    }
    
    public void addActivity(Activity activity)
    {
        activitiesByKey.put(new ActivityKey(activity.getName(), activity.getDate()), activity);
    }
    
    public void removeActivity(Activity activity)
    {
        activitiesByKey.remove(new ActivityKey(activity.getName(), activity.getDate()));
    }
    
    public void removeActivity(String name, String date)
    {
        activitiesByKey.remove(new ActivityKey(name, date));
    }
}
