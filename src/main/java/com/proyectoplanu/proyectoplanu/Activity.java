package com.proyectoplanu.proyectoplanu;

import java.util.HashMap;

public class Activity 
{
    private String name;

    private String date;
    private float hour;
    private String managerRut;
    
    private HashMap<String, Student> students;
    
    public Activity(String date, float hour)
    {
        this.date = date;
        this.hour = hour;
    }
    
    public Activity(String name, String date, float hour, String managerRut)
    {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.managerRut = managerRut;
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
    
    public String getDate() { return date; }
    public float getHour() { return hour; }
    public String getName() { return name; }
    public String getManagerRut() { return managerRut; }
    
    public void setDate(String date) { this.date = date; }
    public void setDate(int day, int month, int year) { date = day + "/" + month + "/" + year; }
    
    public void setHour(float hour) { this.hour = hour; }
    public void setManagerRut(String managerRut) { this.managerRut = managerRut; }
    public void setManagerRut(Manager manager) { this.managerRut = manager.getRut(); }
}
