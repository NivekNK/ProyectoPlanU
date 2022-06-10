package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendary
{
    private HashMap<String, Person> persons;
    private ActivityCollection activities;
    
    public Calendary()
    {
        persons = new HashMap();
        activities = new ActivityCollection();
    }
    
    public void addActivity(Activity activity)
    {
        activities.addActivity(activity);
        
        Manager manager = activity.getManager();
        if (manager != null)
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
        Person person = persons.get(rut);
        if (person.getType() == TypeOfPerson.MANAGER)
            return (Manager)person;
        
        return null;
    }
    
    public void addManager(Manager manager)
    {
        persons.put(manager.getRut(), manager);
    }
    
    public void removeManager(Manager manager)
    {
        persons.remove(manager.getRut());
    }
    
    public void removeManager(String rut)
    {
        persons.remove(rut);
    }
    
    // No es un getter
    public Student getStudent(String rut)
    {
        Person person = persons.get(rut);
        if (person.getType() == TypeOfPerson.STUDENT)
            return (Student)person;
            
        return null;
    }
    
    public void addStudent(Student student)
    {
        persons.put(student.getRut(), student);
    }
    
    public void removeStudent(Student student)
    {
        persons.remove(student.getRut());
    }
    
    public void removeStudent(String rut)
    {
        for (Activity activity : activities.getAllActivities())
        {
            activity.removeStudent(rut);
        }
        
        persons.remove(rut);
    }
    
    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> currentStudents = new ArrayList();
        persons.entrySet().forEach(entry -> 
        {
            Person person = entry.getValue();
            if (person.getType() == TypeOfPerson.STUDENT)
            {
                Student student = (Student)person;
                currentStudents.add(student);
            }
        });
        return currentStudents;
    }
    
    public ArrayList<Manager> getManagers()
    {
        ArrayList<Manager> currentManagers = new ArrayList();
        persons.entrySet().forEach(entry -> 
        {
            Person person = entry.getValue();
            if (person.getType() == TypeOfPerson.MANAGER)
            {
                Manager manager = (Manager)person;
                currentManagers.add(manager);
            }
        });
        return currentManagers;
    }
    
    public void removeActivity(Activity activity)
    {
        activities.removeActivity(activity);
    }
    
    public void removeActivity(String name, String date, float hour)
    {
        activities.removeActivity(name, date, hour);
    }
}
