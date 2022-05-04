package com.proyectoplanu.proyectoplanu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Aun no se realiza ninguna comprobacion de lectura de datos
public class Menu
{
    private MenuAction[] actions;

    private Scanner input;
    
    public Menu()
    {
        input = new Scanner(System.in);
        actions = new MenuAction[11];
        
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
        
        MenuAction removeStudent = (calendary) -> removeStudent(calendary);
        actions[5] = removeStudent;
        
        MenuAction removeActivity = (calendary) -> removeActivity(calendary);
        actions[6] = removeActivity;
        
        MenuAction showSpecificStudent = (calendary) -> showSpecificStudent(calendary);
        actions[7] = showSpecificStudent;
        
        MenuAction showSpecificActivity = (calendary) -> showSpecificActivity(calendary);
        actions[8] = showSpecificActivity;
        
        MenuAction modifyDateAndHourAction = (calendary) -> modifyDateAndHour(calendary);
        actions[9] = modifyDateAndHourAction;
        
        MenuAction generateReportAction = (calendary) -> {
            try
            {
                generateReport(calendary);
            }
            catch (IOException ex)
            {
               System.out.println("No puede generar el reporte!");
            }
        };
        actions[10] = generateReportAction;
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
                         + "6.- Eliminar Estudiante\n"
                         + "7.- Eliminar Actividad\n"
                         + "8.- Mostrar Estudiante Especifico\n"
                         + "9.- Mostrar Actividad Especifica\n"
                         + "10.- Modificar Fecha y Hora Actividad\n"
                         + "11.- Generar reporte\n"
                         + "0.- Salir\n");
                            // TODO: Traspasar Estudiante
                            // TODO: Intercambiar Actividades
    }

    private void option(int alternative, Calendary calendary)
    {
        MenuAction action = actions[alternative - 1];
        action.invoke(calendary);
    }
    
    //---------------------------- OPCION 1 ----------------------------------------//
    
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
        Activity activity = new Activity(name, date, hour, managerRut);
        calendary.addActivity(activity);
    }
    
    //------------------------------------ OPCION 2 ---------------------------//
    
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
    
    //----------------------------------- OPCION 3 ----------------------------//
    
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

    //----------------------------- OPCION 4 ---------------------------------//
    
    private void showStudents(Calendary calendary)
    {
        System.out.println("Lista de estudiantes: \n");
        for (Student student : calendary.getStudents())
        {
            System.out.println(student.getName() + " - " + student.getRut());
        }
    }
    
    //---------------------------------- OPCION 5 -----------------------------//
    
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
    
    //------------------------------- OPCION 6 -------------------------------//
    
    private void removeStudent(Calendary calendary)
    {
        System.out.println("Ingrese rut del estudiante que quiera eliminar\n");
        String rut = input.nextLine();
        
        if (rut == null)
        {
            System.out.println("El estudiante no existe\n");
            return;
        }
        
        calendary.removeStudent(rut);
        System.out.println("El estudiante se ha eliminado exitosamente\n");
    }
 
    //----------------------------------- OPCION 7 ---------------------------//
    
    private void removeActivity(Calendary calendary)
    {
        Activity activity = null;
        String name = "";
        String date = "";
        float hour = 0.0f;
        
        while(activity == null)
        {
            System.out.println("Ingrese nombre de la Actividad ha eliminar");
            name = input.nextLine();
            System.out.println("Ingrese fecha de la Actividad ha eliminar");
            date = input.nextLine();
            System.out.println("Ingrese hora de la Actividad ha eliminar");
            hour = Float.parseFloat(input.nextLine());
            
            activity = calendary.getPlanedActivity(name, date, hour);
            if (activity == null)
            {
                System.out.println("Ingrese una actividad correcta\n");
            }
        }
        
        Manager manager = calendary.getManager(activity.getManagerRut());
        manager.removeActivity(activity);
        calendary.removeActivity(name, date, hour);
        System.out.println("La Actividad se ha removido existosamente\n");
    }
    
    //------------------------------------ OPCION 8 -----------------------------//
    
    private void showSpecificStudent (Calendary calendary)
    {
        System.out.println("Ingrese rut del estudiante: ");
        String rut = input.nextLine();
        Student student = calendary.getStudent(rut);
        System.out.println("Nombre: " + student.getName());
        System.out.println("Edad: " + student.getAge()); 
        System.out.println("Año: "+ student.getGrade());
    }
    
    //--------------------------- OPCION 9 -----------------------------------//
    
    private void showSpecificActivity (Calendary calendary)
    {
        System.out.println("Ingrese nombre de la Actividad ha buscar \n");
        String name = input.nextLine();
        System.out.println("Ingrese fecha de la Actividad ha buscar \n");
        String date = input.nextLine();
        System.out.println("Ingrese Hora de la Activiadad ha buscar \n");
        float hour = Float.parseFloat(input.nextLine());
        
        Activity activity = calendary.getPlanedActivity(name, date, hour);
        
        System.out.println("Actividad: " + activity.getName());
        System.out.println("Fecha: " + activity.getDate());
        System.out.println("Hora: " + activity.getHour());
        System.out.println("Rut del Manager: " + activity.getManagerRut());
        System.out.println("-----------------------------------------");
        System.out.println("Participantes de la Actividad: ");

        for (Student student : activity.getStudents())
        {
            System.out.println("Nombre: " + student.getName());
            System.out.println("Edad: " + student.getAge()); 
            System.out.println("Año: "+ student.getGrade());
            System.out.println("-----------------------------------------");
        }
    }
    
    //---------------------------------- OPCION 10 -----------------------------//
    
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
        
        calendary.addActivity(newActivity);
    }
    
    //---------------------------------- OPCION 11 -----------------------------//
    
    private void generateReport(Calendary calendary) throws IOException
    {
        File reportFile = null;
        try
        {
            reportFile = new File("Reporte.txt");
            if (reportFile.createNewFile())
                System.out.println("Archivo creado: " + reportFile.getName());
            else
                System.out.println("El archivo ya existe!");
        }
        catch (IOException e)
        {
            System.out.println("Ocurrió un error al intentar crear el archivo de reporte!");
        }
        
        try (FileWriter writer = new FileWriter(reportFile)) 
        {
            String report = "";
            ActivityCollection collection = calendary.getActivityCollection();
            for (Activity activity : collection.getAllActivities())
            {
                report += ("Actividad: " + activity.getName() + "\n");
                report += "\n";
                report += ("Fecha: " + activity.getDate() + "\n");
                report += ("Hora: " + activity.getHour() + "\n");
                Manager manager = calendary.getManager(activity.getManagerRut());
                report += ("Manager: " + manager.getName() + " | " + manager.getRut() + "\n");
                report += "\n";
                report += "Asistentes:\n";
                for (Student student : activity.getStudents())
                {
                    report += (" - " + student.getName() + " | " + student.getRut() + "\n");
                }
                report += "\n\n";
            }
            writer.write(report);
            writer.close();
        }
    }
}
