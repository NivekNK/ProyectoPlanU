package com.proyectoplanu.proyectoplanu;

public class Manager 
{
    private int age;
    private String name;
    private String job;
    
    public Manager()
    {
        age = 18;
        name = "Juan Perez";
        job = "Encargado";
    }
    
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getJob() {return job; }
    
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setJob(String job) {this.job = job; }
}
