package com.proyectoplanu.proyectoplanu.strategy;

import javax.swing.JButton;

public class ThertyOneDayMonth implements MonthType
{
    @Override
    public void setVisibleButtons(JButton day29, JButton day30, JButton day31)
    {
        day29.setVisible(true);
        day30.setVisible(true);
        day31.setVisible(true);
    }
}
