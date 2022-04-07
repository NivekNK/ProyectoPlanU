package com.proyectoplanu.proyectoplanu;

import java.util.Scanner;

public class Menu
{
    private MenuAction addNewActivity;
    
    private Scanner input;
    
    public Menu()
    {
        input = new Scanner(System.in);
        
        addNewActivity = new MenuAction()
        {
            @Override
            public void invoke(Calendary calendary)
            {
                System.out.println("Ingrese nombre de la actividad: ");
                String name = input.nextLine();
                System.out.println("Ingrese fecha separada por / (EJ: 14/07/2022): ");
                String date = input.nextLine();
                System.out.println("Ingrese hora separada por punto (EJ: 10.30): ");
                float hour = Float.parseFloat(input.nextLine());
                
                Manager manager = null;
                String rut = null;
                while (manager == null)
                {
                    System.out.println("Ingrese rut de manager correcto (EJ: 20410798-K): ");
                    rut = input.nextLine();
                    manager = calendary.getManager(rut);
                    
                    if (manager == null)
                        System.out.println("Manager que se ha intentado buscar no existe.");
                }
                
                Activity activity = new Activity(name, date, hour, rut);
                calendary.planActivity(activity);
            }
        };
    }
    
    public void printMenu()
    {
        //clearConsole();
        
        System.out.println("Menú sistema de Actividades\n"
                         + "\n"
                         + "Ingrese la opción que quiera realizar:\n"
                         + "1.- Agregar actividad nueva\n"
                         + "2.- Agregar estudiante a una actividad\n"
                         + "3.- Mostrar lista de actividades\n"
                         + "4.- Mostrar lista de estudiantes\n"
                         + "5.- Mostrar participantes de una actividad\n");
    }

    public void option(int i, Calendary calendary)
    {
        switch (i)
        {
            case 1:
                addNewActivity.invoke(calendary);
                break;
        }
    }
    
    /*public static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }*/

}
