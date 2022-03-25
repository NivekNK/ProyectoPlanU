package com.proyectoplanu.proyectoplanu;

public class Student 
{
    private int age;
    private String name;
    private int years;
    
    public Student()
    {
        age = 18;
        name = "Julio Martinez";
        years = 1;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
    public int getYears() { return years; }

    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setYears(int years) {this.years = years; }
}
