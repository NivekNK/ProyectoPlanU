package com.proyectoplanu.proyectoplanu;

public class ActivityKey
{
    private String name;
    private String date;
    
    public ActivityKey(String name, String date)
    {
        this.name = name;
        this.date = date;
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
}
