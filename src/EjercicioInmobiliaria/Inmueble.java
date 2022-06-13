/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioInmobiliaria;

import java.io.Serializable;

/**
 *
 * @author Alberto
 */
public class Inmueble implements Serializable {
    private String direccion;
    private String ciudad;
    private String tipo;

public Inmueble (String direccion, String ciudad, String tipo){
    this.direccion=direccion;
    this.ciudad=ciudad;
    this.tipo=tipo;
    
}

public String getDireccion(){
    return direccion;
}

public String getCiudad(){
    return ciudad;
}
public String getTipo(){
    return tipo;
}

public String toString(){
    return "Direccion: " +direccion + "  Ciudad: " +ciudad + "  Tipo: " +tipo;
}
}
