package com.proyectoplanu.proyectoplanu;

import java.util.HashMap;
import java.util.ArrayList;

public class ActivityCollection implements ReportGenerator
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
    public Activity getActivity(String name, String date, float hour)
    {
        return getActivity(new ActivityKey(name, date, hour));
    }
    
    // No es un getter
    public Activity getActivity(ActivityKey activityKey)
    {
        return activitiesByKey.get(activityKey);
    }
    
    public void addActivity(Activity activity)
    {
        activitiesByKey.put(new ActivityKey(activity.getName(), activity.getDate(), activity.getHour()), activity);
    }
    
    public void removeActivity(Activity activity)
    {
        activitiesByKey.remove(new ActivityKey(activity.getName(), activity.getDate(), activity.getHour()));
    }
    
    public void removeActivity(String name, String date, float hour)
    {
        activitiesByKey.remove(new ActivityKey(name, date, hour));
    }

    @Override
    public String generateReport()
    {
        String report = "";
        for (Activity activity : this.getAllActivities())
        {
            report += activity.generateReport();
            report += "\n";
            report += "Asistentes:\n";
            for (Student student : activity.getStudents())
            {
                report += student.generateReport();
            }
            report += "\n\n";
        }
        
        return report;
    }
}
