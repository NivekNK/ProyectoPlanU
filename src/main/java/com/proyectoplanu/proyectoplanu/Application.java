package com.proyectoplanu.proyectoplanu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application
{
    private Calendary calendary;
    private Menu menu;
    
    public void Run() throws FileNotFoundException, IOException
    {
        menu = new Menu();
        calendary = new Calendary();

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
        
        CSV activities = new CSV("Activities");
        String activityLine = activities.firstLine();
        while (activityLine != null)
        {
            Activity activity = new Activity(activities.get_csvField(activityLine, 0),
                                             activities.get_csvField(activityLine, 1),
                                             Float.parseFloat(activities.get_csvField(activityLine, 2)),
                                             activities.get_csvField(activityLine, 3));
            calendary.planActivity(activity);
            activityLine = activities.nextLine();
        }
        
        calendary.printCalendary();
        
        menu.printMenu();
        menu.option(1, calendary);
        
        // Test
        Manager manager = calendary.getManager("20369789-8");
        System.out.println("Activities managed by " + manager.getName() + "\n");
        manager.getManagedActivities().forEach(key ->
        {
            Activity activity = calendary.getPlanedActivity(key);
            System.out.println("Activity: " + activity.getName());
            System.out.println("Date: " + activity.getDate());
            System.out.println("Hour: " + activity.getHour());
            System.out.println("Manager Rut: " + activity.getManagerRut());
            System.out.println("-                  *                    -");
        });
    }
}
