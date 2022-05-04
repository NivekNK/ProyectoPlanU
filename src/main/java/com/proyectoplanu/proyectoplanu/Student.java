package com.proyectoplanu.proyectoplanu;

public class Student extends Person
{
    private int grade;

    public Student(String rut, int age, String name, int grade)
    {
        this.rut = rut;
        this.age = age;
        this.name = name;
        this.grade = grade;
    }
    
    public int getGrade() { return grade; }
    
    public void setGrade(int grade) {this.grade = grade; }
}
