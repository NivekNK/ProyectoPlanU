package com.proyectoplanu.proyectoplanu;

import java.io.IOException;

public class EntryPoint
{
    public static void main(String[] arg) throws IOException, StartProjectException
    {
        Application app = Application.getInstance();
        app.run();
    }
}