package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendary
{
    private HashMap<String, Manager> managers;
    private HashMap<String, Student> students;
    private ActivityCollection activities;
    
    public Calendary()
    {
        managers = new HashMap();
        students = new HashMap();
        activities = new ActivityCollection();
    }
    
    public void planActivity(Activity activity)
    {
        activities.addActivity(activity);
        
        String managerRut = activity.getManagerRut();
        Manager manager = managers.get(managerRut);
        if (manager == null) return;

        manager.addManagedActivity(activity);
    }
    
    public ActivityCollection getActivityCollection (){return activities;} 
    
    public Activity getPlanedActivity(ActivityKey activityKey)
    {
        return activities.getActivity(activityKey);
    }
    
    public Activity getPlanedActivity(String name, String date, float hour)
    {
        return activities.getActivity(new ActivityKey(name, date, hour));
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
    
    // No es un getter
    public Student getStudent(String rut)
    {
        return students.get(rut);
    }
    
    public void addStudent(Student student)
    {
        students.put(student.getRut(), student);
    }
    
    public void removeStudent(Student student)
    {
        students.remove(student.getRut());
    }
    
    public void removeStudent(String rut)
    {
        students.remove(rut);
    }
    
    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> currentStudents = new ArrayList();
        students.entrySet().forEach(entry -> 
        {
            Student student = entry.getValue();
            currentStudents.add(student);
        });
        return currentStudents;
    }
}
