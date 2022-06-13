/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
* Esta clase denominada Asignatura modela una determinada
* asignatura que tiene un nombre, código y cantidad de créditos. La
* clase implementa la interfaz Serializable que permite guardar objetos
* en un archivo de datos.
* @author Alberto Sanchez Dominguez
* @version 13.0
*/
public class Asignatura implements Serializable{
    private int codigo; // Atributo que identifica el código de la asignatura
    private String nombre; // Atributo que identifica el nombre de la asignatura
    private int creditos; //  Atributo que identifica la cantidad de créditos que tiene la asignatura 

/**
* Constructor de la clase Asignatura
* @param codigo Parámetro que define el código de la asignatura
* @param nombre Parámetro que define el nombre de la asignatura
* @param creditos Parámetro que define la cantidad de créditos de
* la asignatura.
*/
    
public Asignatura(int codigo, String nombre, int Creditos){
    this.codigo=codigo;
    this.nombre=nombre;
    this.creditos=creditos;
}

/**
* Método que muestra en pantalla los datos de una asignatura
*/

public void imprimir(){
    System.out.println("Codigo de la asignatura: " +codigo);
    System.out.println("Nombre de la asignatura: " +nombre);
    System.out.println("Creditos de la asignatura: " +creditos);
}

/**
* Método que leer un archivo de datos, los asigna a los atributos de
* un objeto Asignatura y muestra su contenido en pantalla
* @throws FileNotFoundException Excepción que indica que no se
* pudo leer el archivo
* @throws IOException Excepción que indica que se presentó un
* error de entrada/salida
* @throws Exception Excepción general
*/

public void leerAsignatura(){
    try{
        FileInputStream archivo = new FileInputStream("Asignatura.dat"); // Define el archivo a leer
        // Crea el objeto de flujo de entrada para la lectura del objeto
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        // Lee el objeto en el flujo de entrada
        Asignatura asignatura = (Asignatura) entrada.readObject();
        asignatura.imprimir(); ; // Muestra en pantalla los datos del objeto leído */
        entrada.close();
    }catch(FileNotFoundException fnfe){ // Captura una excepción en caso de no encontrar el archivo
        System.out.println("No se pudo leer el archivo.");
    }catch(IOException ioe){ // Captura una excepción en caso de ocurrir un error de entrada/salida.
        System.out.println("Error de entrada/salida.");
    }catch(Exception e){ // Captura una excepción general
        System.out.println("Error al leer el archivo.");
    }
}

/**
* Método que crea un archivo y guarda los datos de un objeto
* Asignatura
* @throws IOException Excepción que indica que no se pudo
* escribir en el archivo
*/

public void escribirAsignatura(){
    try{
        // Define el archivo donde se guardarán los datos del objeto
        FileOutputStream archivo = new FileOutputStream("Asignatura.dat");
        // Crea el objeto de flujo de salida para la escritura del objeto
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        salida.writeObject(this);// Escribe el objeto en el flujo de salida
        salida.close(); // Cierra el flujo de salida de datos
    }catch (IOException e){
        /* Captura una excepción en caso de ocurrir un error en la
        escritura de datos del archivo */
        System.out.println("No se pudo escribir el archivo.");
    }
}
}
