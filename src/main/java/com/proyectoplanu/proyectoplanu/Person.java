package com.proyectoplanu.proyectoplanu;

public abstract class Person
{
    private String rut;
    private int age;
    private String name;
    
    protected Person(String rut, int age, String name)
    {
        this.rut = rut;
        this.age = age;
        this.name = name;
    }
    
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getRut() { return rut; }
    public abstract TypeOfPerson getType();
    
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setRut(String rut) {this.rut = rut; }
}
