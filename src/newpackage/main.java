
package newpackage;

/**
 * Esta clase prueba la creación de un objeto Asignatura y lo guarda en
 * un archivo de datos. Luego lo lee y muestra su contenido en pantalla.
 * @author Alberto
 */
public class main {

    /**
     * Método main que prueba la creación de una asignatura, guarda el
     * objeto creado en un archivo de datos y luego, lee el archivo y
     * muestra su contenido en pantalla.
     */
    public static void main(String[] args) {
        Asignatura as = new Asignatura (4100547, "POO", 4);
        Asignatura as2 = new Asignatura (420000, "PSS", 6);
        
        as.escribirAsignatura();
        as.leerAsignatura();
        
        as2.escribirAsignatura();
        as2.leerAsignatura();
    }
    
}
