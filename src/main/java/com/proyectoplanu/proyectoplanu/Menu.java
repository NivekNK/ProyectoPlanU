package com.proyectoplanu.proyectoplanu;

import java.util.Scanner;

// Aun no se realiza ninguna comprobacion de lectura de datos
public class Menu
{
    private MenuAction[] actions;

    private Scanner input;
    
    public Menu()
    {
        input = new Scanner(System.in);
        actions = new MenuAction[6];
        
        MenuAction addNewActivityAction = (calendary) -> addNewActivity(calendary);
        actions[0] = addNewActivityAction;
        
        // porfavor ingresar solo datos que ya existan y sean correctos :)
        MenuAction addStudentToActivityAction = (calendary) -> addStudentToActivity(calendary);
        actions[1] = addStudentToActivityAction;
        
        MenuAction showActivitiesAction = (calendary) -> showActivities(calendary);
        actions[2] = showActivitiesAction;
        
        MenuAction showStudentsAction = (calendary) -> showStudents(calendary);
        actions[3] = showStudentsAction;
        
        MenuAction showStudentsInActivityAction = (calendary) -> showStudentsInActivity(calendary);
        actions[4] = showStudentsInActivityAction;
        
        MenuAction modifyDateAndHourAction = (calendary) -> modifyDateAndHour(calendary);
        actions[5] = modifyDateAndHourAction;
    }
    
    public boolean showMenu(Calendary calendary)
    {
        printMenu();
        
        System.out.println("Ingrese opcion: ");
        int alternative = input.nextInt();
        input.nextLine();
        if (alternative == 0) return true;
        
        if (alternative < 0 || alternative > actions.length)
        {
            System.out.println("Opcion incorrecta!");
            return false;
        }
        
        option(alternative, calendary);
        
        return false;
    }
    
    private void printMenu()
    {
        System.out.println("Menú sistema de Actividades\n"
                         + "\n"
                         + "Ingrese la opción que quiera realizar:\n"
                         + "1.- Agregar actividad nueva\n"
                         + "2.- Agregar estudiante a una actividad\n"
                         + "3.- Mostrar lista de actividades\n"
                         + "4.- Mostrar lista de estudiantes\n"
                         + "5.- Mostrar participantes de una actividad\n"
                         + "10.- Modificar Fecha y Hora Actividad\n"
                         + "0.- Salir\n");
                            // TODO: Traspasar Estudiante
                            // TODO: Intercambiar Actividades
    }

    private void option(int alternative, Calendary calendary)
    {
        MenuAction action = actions[alternative - 1];
        action.invoke(calendary);
    }
// esta parte no nos sirve para interfaces    
    private void addNewActivity(Calendary calendary)
    {
        boolean exists = true;
        String name = null;
        String date = null;
        float hour = 0.0f;
        
        while (exists)
        {
            System.out.println("Ingrese nombre de la actividad: ");
            name = input.nextLine();
            System.out.println("Ingrese fecha separada por / (EJ: 14/07/2022): ");
            date = input.nextLine();
            System.out.println("Ingrese hora separada por punto (EJ: 10.30): ");
            hour = Float.parseFloat(input.nextLine());
            
            if (calendary.getPlanedActivity(name, date, hour) == null)
                exists = false;
            else
                System.out.println("Actividad ya planeada!");
        }

        Manager manager = null;
        String managerRut = null;
        while (manager == null)
        {
            System.out.println("Ingrese rut de manager correcto (EJ: 20410798-K): ");
            managerRut = input.nextLine();
            manager = calendary.getManager(managerRut);

            if (manager == null)
                System.out.println("Manager que se ha intentado buscar no existe.");
        }
// esta parte sirve para interfaces
        Activity activity = new Activity(name, date, hour, managerRut);
        calendary.planActivity(activity);
    }
    
    private void addStudentToActivity(Calendary calendary)
    {
        Student student = null;
        while (student == null)
        {
            System.out.println("Ingrese rut del estudiante");
            String rut = input.nextLine();
            
            student = calendary.getStudent(rut);
            if (student == null)
            {
                System.out.println("Estudiante no existe!");
            }
        }
        
        Activity activity = null;
        while (activity == null)
        {
            System.out.println("Ingrese nombre de la actividad");
            String name = input.nextLine();
            System.out.println("Ingrese fecha de la actividad");
            String date = input.nextLine();
            System.out.println("Ingrese hora de la actividad");
            float hour = Float.parseFloat(input.nextLine());
            
            activity = calendary.getPlanedActivity(name, date, hour);
            if (activity == null)
                System.out.println("Actividad ingresada no existe!");
        }
        
        activity.addStudent(student);
        System.out.println("El estudiante ha sido agregado a actividad " + activity.getName() + "\n");
    }
    
    private void showActivities(Calendary calendary)
    {
        System.out.println("Lista de actividades: \n");
        ActivityCollection activities = calendary.getActivityCollection();
        activities.getAllActivities().forEach(activity ->
        {
            System.out.println("Actividad: " + activity.getName());
            System.out.println("Fecha: " + activity.getDate());
            System.out.println("Hora: " + activity.getHour());
            System.out.println("Rut del Manager: " + activity.getManagerRut());
            System.out.println("-----------------------------------------");
        });
    }
    
    private void showStudents(Calendary calendary)
    {
        System.out.println("Lista de estudiantes: \n");
        for (Student student : calendary.getStudents())
        {
            System.out.println(student.getName() + " - " + student.getRut());
        }
    }
    
    private void showStudentsInActivity(Calendary calendary)
    {
        Activity activity = null;
        while (activity == null)
        {
            System.out.println("Ingrese nombre de la actividad");
            String name = input.nextLine();
            System.out.println("Ingrese fecha de la actividad");
            String date = input.nextLine();
            System.out.println("Ingrese hora de la actividad");
            float hour = Float.parseFloat(input.nextLine());
            
            activity = calendary.getPlanedActivity(name, date, hour);
            if (activity == null)
                System.out.println("Actividad ingresada no existe!");
        }
        
        System.out.println("Lista de estudiantes participantes: \n");
        for (Student student : activity.getStudents())
        {
            System.out.println(student.getName() + " - " + student.getRut());
        }
        System.out.println("\n");
    }
    
    private void modifyDateAndHour(Calendary calendary)
    {
        Activity activity = null;
        while (activity == null)
        {
            System.out.println("Ingrese nombre de la actividad");
            String name = input.nextLine();
            System.out.println("Ingrese fecha de la actividad");
            String date = input.nextLine();
            System.out.println("Ingrese hora de la actividad");
            float hour = Float.parseFloat(input.nextLine());
            
            activity = calendary.getPlanedActivity(name, date, hour);
            if (activity == null)
                System.out.println("Actividad ingresada no existe!");
        }
        
        Manager manager = calendary.getManager(activity.getManagerRut());
        manager.removeActivity(activity);
        
        calendary.removeActivity(activity);
        
        System.out.println("Nuevos datos:\n");
        
        System.out.println("Ingrese nueva fecha de la actividad");
        String date = input.nextLine();
        System.out.println("Ingrese nueva hora de la actividad");
        float hour = Float.parseFloat(input.nextLine());
        
        Activity newActivity = new Activity(activity.getName(), date, hour, activity.getManagerRut());
        for (Student student : activity.getStudents())
        {
            newActivity.addStudent(student);
        }
        manager.addManagedActivity(newActivity);
        
        calendary.planActivity(newActivity);
    }
}
