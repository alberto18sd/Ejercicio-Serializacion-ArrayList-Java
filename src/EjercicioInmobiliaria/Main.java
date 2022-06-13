/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjercicioInmobiliaria;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Inmueble> inm = new ArrayList<Inmueble>();
        
        
        do{
            System.out.println("1. Introducir inmueble.");
            System.out.println("2. Mostrar listado.");
            System.out.println("3. Borrar inmueble.");
            System.out.println("4. Salir.");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                        System.out.println("Introduce la direccion del inmueble");
                        String direccion = sc.nextLine();
                        System.out.println("Introduce la ciudad del inmueble.");
                        String ciudad = sc.nextLine();
                        System.out.println("Introduce si el inmueble es para ARRENDAR o 2 si esta destinado para la VENTA.");
                        String tipo = sc.nextLine();
                        inm.add(new Inmueble(direccion, ciudad, tipo));
                        
                    try{
                        ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("Inmueble.dat"));
                        escribiendo_fichero.writeObject(inm);
                        escribiendo_fichero.close();
                        System.out.println("Registro introducido");
                    }catch(FileNotFoundException fnfe){
                        System.out.println("\nERROR: Fichero no encontrado.");
                    }catch(IOException e){
                        System.out.println("\nERROR: No se puede acceder al fichero.");
                    }
                break;

                    
                case 2:
                    try{
                        ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("Inmueble.dat"));
                        inm = (ArrayList) recuperando_fichero.readObject();
                        recuperando_fichero.close();
                        System.out.println("El contenido del array leido del fichero es el siguiente: ");
                        for(Inmueble e : inm){
                            System.out.println(e);}
                        
                        
                    }catch(FileNotFoundException fnfe){
                        System.out.println("\nERROR: Fichero no encontrado.");
                    }catch(IOException ioe){
                        System.out.println("\nERROR: No se puede acceder al fichero.");
                    }catch(ClassNotFoundException e){
                        System.out.println("\nERROR: No se encuentra la clase.");
                    }
                    
                break;
                
                case 3:
                    System.out.println("Introduce la direccion del inmueble que desea borrar: ");
                    String direccionIntroducida=sc.next();
                    try{
                        if(!inm.contains(new Inmueble(direccionIntroducida,"",""))){
                        System.out.println("Lo siento, no se ha encontrado el inmueble con la direccion indicada.");
                        }else{
                        inm.remove(inm.indexOf(new Inmueble(direccionIntroducida,"","")));
                        System.out.println("Inmueble eliminado con exito.");
                    }  
                    }catch(InputMismatchException ex){
                        System.out.println("Ha ocurrido un error inesperado.");
                    }
                    
                break;
                    
            }
        }while(opcion!=4);
        
        
        
       
        
        /*
         * No creamos los objetos para manejar objetos,
         * ya que sino siempre existiria el fichero
         */
        
        
    }
    
    public static void muestraDatos(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        //Cuando se acabe el ficheor saltara la excepcion EOFException
        while(true){
            Inmueble ref=(Inmueble)ois.readObject();
            
            System.out.println("La direccion del inmueble es: " +ref.getDireccion() + ", situado en " +ref.getCiudad() + " y de tipo: " +ref.getTipo());
        }
    }
}
