package com.proyectoplanu.proyectoplanu;

public class Student 
{
    private String rut;
    private int age;
    private String name;
    private int years;

    public Student(String rut, int age, String name, int years)
    {
        this.rut = rut;
        this.age = age;
        this.name = name;
        this.years = years;
    }
    
    public String getRut() {return rut; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public int getYears() { return years; }
    
    public void setRut(String rut) {this.rut = rut; }
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setYears(int years) {this.years = years; }
}
