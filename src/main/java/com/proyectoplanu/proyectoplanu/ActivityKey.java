package com.proyectoplanu.proyectoplanu;

public class ActivityKey
{
    private String name;
    private String date;
    private float hour;
    
    public ActivityKey(String name, String date, float hour)
    {
        this.name = name;
        this.date = date;
        this.hour = hour;
    }

    @Override   
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ActivityKey))
            return false;

        ActivityKey ref = (ActivityKey)obj;
        return this.name.equals(ref.name) && this.date.equals(ref.date);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode() ^ date.hashCode();
    }
    
    private String getName() { return name; }
    private String getDate() { return date; }
    private float getHour() { return hour; }
}
