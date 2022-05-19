package com.proyectoplanu.proyectoplanu;

public class Student extends Person implements ReportGenerator
{
    private int grade;

    public Student(String rut, int age, String name, int grade)
    {
        super(rut, age, name);
        this.grade = grade;
    }
    
    public int getGrade() { return grade; }
    
    public void setGrade(int grade) {this.grade = grade; }

    @Override
    public TypeOfPerson getType()
    {
        return TypeOfPerson.STUDENT;
    }

    @Override
    public String generateReport()
    {
        return " - " + this.getName() + " | " + this.getRut() + "\n";
    }
}
