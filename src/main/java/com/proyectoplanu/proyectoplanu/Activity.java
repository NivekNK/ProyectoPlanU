package com.proyectoplanu.proyectoplanu;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity implements ReportGenerator
{
    private String name;
    protected String date;
    protected float hour;

    private Manager manager;
    //Key students = rut
    private HashMap<String, Student> students;
    
    public Activity(String date, float hour)
    {
        this.date = date;
        this.hour = hour;
    }
    
    public Activity(String name, String date, float hour, Manager manager)
    {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.manager = manager;
        students = new HashMap();
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
    
    // No es un getter
    public Student getStudent(String rut)
    {
        return students.get(rut);
    }
    
    public static String parseDate(int day, int month, int year)
    {
        String date = day <= 9 ? "0" + Integer.toString(day) : Integer.toString(day);
        date += "/";
        date += month <= 9 ? "0" + Integer.toString(month) : Integer.toString(month);
        date += "/" + Integer.toString(year);
        
        return date;
    }
    
    public String getName() { return name; }
    public String getDate() { return date; }
    public float getHour() { return hour; }
    public Manager getManager() { return manager; }
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

    public void setHour(float hour) { this.hour = hour; }
    public void setManager(Manager manager) { this.manager = manager; }

    @Override
    public String generateReport() 
    {
        String report = "";
        report += ("Actividad: " + name + "\n");
        report += "\n";
        report += ("Fecha: " + date + "\n");
        report += ("Hora: " + hour + "\n");
        
        report += manager.generateReport();
        
        return report;
    }
}
