package com.proyectoplanu.proyectoplanu;

public abstract class Person
{
    protected String rut;
    protected int age;
    protected String name;
    
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getRut() {return rut; }
    
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setRut(String rut) {this.rut = rut; }
}
