package com.proyectoplanu.proyectoplanu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Application
{
    private ArrayList<Activity> activities;
    
    public void Run() throws FileNotFoundException, IOException
    {
        activities = new ArrayList();
        
        CSV csv = new CSV("Activities");
        String line = csv.firstLine();
        while (line != null)
        {
            Activity activity = new Activity(csv.get_csvField(line, 0), 
                                            Float.parseFloat(csv.get_csvField(line, 1)), 
                                            csv.get_csvField(line, 3),
                                            new Manager());
            activities.add(activity);
            
            line = csv.nextLine();
        }
        
        for (Activity activity : activities)
        {
            System.out.println("Actividad: " + activity.getNameActivity());
            Manager manager = activity.getManager();
            System.out.println("Encargado: " + manager.getName());
            System.out.println("Fecha - Hora: " + activity.getDate() + "/" + activity.getHour());
        }
    }
}
