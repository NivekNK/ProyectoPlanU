package com.proyectoplanu.proyectoplanu;

import java.io.IOException;

public class EntryPoint
{
    public static void main(String[] arg) throws IOException
    {
        Application app = Application.getInstance();
        app.run();
    }
}