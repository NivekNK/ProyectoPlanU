package com.proyectoplanu.proyectoplanu.strategy;

public class DateContext
{
    private DateFormatStrategy strategy;
    
    public DateContext(DateFormatStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public void setStrategy(DateFormatStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public String parseDate(int day, int month, int year)
    {
        return strategy.parseDate(day, month, year);
    }
}
