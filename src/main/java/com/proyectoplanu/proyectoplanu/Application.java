package com.proyectoplanu.proyectoplanu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Application
{
    private static Application Instance = null; 
    
    private Calendary calendary;
    private Menu menu;
    
    private Application() throws IOException
    {
        menu = new Menu();
        calendary = new Calendary();
        
        importManagers();
        importStudents();
        importActivities();
    }
    
    public static Application getInstance() throws IOException
    {
        if (Instance == null)
            Instance = new Application();
        
        return Instance;
    }
    
    public void Run()
    {
        // Test Code
        Random rand = new Random();
        ActivityCollection collection = calendary.getActivityCollection();
        for (Activity activity : collection.getAllActivities())
        {
            for (Student student : calendary.getStudents())
            {
                int randValue = rand.nextInt(100);
                if (randValue < 50)
                {
                    activity.addStudent(student);
                }
            }
        }
        
        boolean exit = false;
        while (exit == false)
        {
            exit = menu.showMenu(calendary);
        }
    }
    
    private void importManagers() throws FileNotFoundException, IOException
    {
        CSV managers = new CSV("Managers");
        String managerLine = managers.firstLine();
        while (managerLine != null)
        {
            Manager manager = new Manager(managers.get_csvField(managerLine, 0),
                                          Integer.parseInt(managers.get_csvField(managerLine, 1)),
                                          managers.get_csvField(managerLine, 2));
            calendary.addManager(manager);
            managerLine = managers.nextLine();
        }
        managers.close();
    }
    
    private void importStudents() throws FileNotFoundException, IOException
    {
        CSV students = new CSV("Students");
        String studentLine = students.firstLine();
        while (studentLine != null)
        {
            Student student = new Student(students.get_csvField(studentLine, 0),
                                          Integer.parseInt(students.get_csvField(studentLine, 1)),
                                          students.get_csvField(studentLine, 2),
                                          Integer.parseInt(students.get_csvField(studentLine, 3)));
            calendary.addStudent(student);
            studentLine = students.nextLine();
        }
        students.close();
    }
    
    private void importActivities() throws FileNotFoundException, IOException
    {
        CSV activities = new CSV("Activities");
        String activityLine = activities.firstLine();
        while (activityLine != null)
        {
            Manager manager = calendary.getManager(activities.get_csvField(activityLine, 3));
            Activity activity = new Activity(activities.get_csvField(activityLine, 0),
                                             activities.get_csvField(activityLine, 1),
                                             Float.parseFloat(activities.get_csvField(activityLine, 2)),
                                             manager);
            calendary.addActivity(activity);
            activityLine = activities.nextLine();
        }
        activities.close();
    }
}
