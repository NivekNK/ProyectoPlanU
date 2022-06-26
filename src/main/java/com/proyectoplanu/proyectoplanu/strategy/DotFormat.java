package com.proyectoplanu.proyectoplanu.strategy;

public class DotFormat implements DateFormatStrategy
{

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return The date in format 14.07.2022
     */
    @Override
    public String parseDate(int day, int month, int year)
    {
        String date = day <= 9 ? "0" + Integer.toString(day) : Integer.toString(day);
        date += ".";
        date += month <= 9 ? "0" + Integer.toString(month) : Integer.toString(month);
        date += "." + Integer.toString(year);
        
        return date;
    }
}
