package com.proyectoplanu.proyectoplanu.strategy;

import javax.swing.JButton;

public class TwentyEightDayMonth implements MonthType
{
    @Override
    public void setVisibleButtons(JButton day29, JButton day30, JButton day31)
    {
        day29.setVisible(false);
        day30.setVisible(false);
        day31.setVisible(false);
    }
}
