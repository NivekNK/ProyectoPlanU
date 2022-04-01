package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendary 
{
    private HashMap<String, Manager> managers;
    private ActivityCollection activities;
    
    public Calendary()
    {
        managers = new HashMap();
        activities = new ActivityCollection();
    }
    
    public void planActivity(String activityName, String activityDate, float activityHour, String managerRut)
    {
        
    }
    
    public ArrayList<Activity> getManagedActivitiesBy(Manager manager)
    {
        ArrayList<Activity> managerActivities = new ArrayList();
        manager.getManagedActivities().forEach(key -> {
            managerActivities.add(activities.getActivity(key));
        });
        return managerActivities;
    }
    
    // No es un getter
    public Manager getManager(String rut)
    {
        return managers.get(rut);
    }
    
    public void addManager(Manager manager)
    {
        managers.put(manager.getRut(), manager);
    }
    
    public void removeManager(Manager manager)
    {
        managers.remove(manager.getRut());
    }
    
    public void removeManager(String rut)
    {
        managers.remove(rut);
    }
}
