package com.proyectoplanu.proyectoplanu.strategy;

import javax.swing.JButton;

public class MonthContext
{
    private MonthType monthType;
    
    public MonthContext(MonthType monthType)
    {
        this.monthType = monthType;
    }
    
    public void setVisibleButtons(JButton day29, JButton day30, JButton day31)
    {
        monthType.setVisibleButtons(day29, day30, day31);
    }
    
    public void swapStrategy(MonthType monthType)
    {
        this.monthType = monthType;
    }
}
