
package LecturaYEscrituraCombinados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

/**
 *
 * @author Alberto
 */
public class Main {

    /**
     * En el ejemplo que presentamos a continuación hay dos flujos de lectura y uno de
     * escritura. Observa que se declaran en total tres manejadores de fichero (dos para
     * lectura y uno para escritura). El programa va leyendo, de forma alterna, una línea de
     * cada fichero - una línea de fichero1.txt y otra línea de fichero2.txt - mientras queden
     * líneas por leer en alguno de los ficheros; y al mismo tiempo va guardando esas líneas
     * en otro fichero con nombre mezcla.txt.
     * 
     */
    public static void main(String[] args) {
       
        try{
            BufferedReader br1 = new BufferedReader(new FileReader("fichero1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("fichero2.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("mezcla.txt"));
            
            String linea1= "";
            String linea2= "";
            
            while((linea1!=null)&&(linea2!=null)){
                linea1=br1.readLine();
                linea2=br2.readLine();
                if(linea1!=null){
                    bw.write(linea1 + "\n");
                }
                if(linea2!=null){
                    bw.write(linea2 + "\n");
                }
            }
            
            br1.close();
            br2.close();
            bw.close();
            
            System.out.println("Archivo mezcla.txt creado satisfactoriamente.");
        } catch(IOException ioe){
            System.out.println("Se ha producido un error de lectura/escritura");
            System.out.println(ioe.getMessage());  
        }
    }
    
}
