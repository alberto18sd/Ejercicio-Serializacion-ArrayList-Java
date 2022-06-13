/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioInmobiliaria;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Alberto
 */
public class MiObjectOutputStream extends ObjectOutputStream{
    //Sobrescribimos el método que crea la cabecera
    protected void writeStreamHeader() throws IOException
    {
        // No hacer nada.
    }
 
    //Constructores
 
    public MiObjectOutputStream () throws IOException{
        super();
    }
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }
}
