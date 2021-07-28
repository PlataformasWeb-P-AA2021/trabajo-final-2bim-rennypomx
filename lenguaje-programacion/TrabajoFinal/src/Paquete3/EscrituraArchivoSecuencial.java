/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete3;
import Paquete2.PlanCelular;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author Renny
 */

public class EscrituraArchivoSecuencial {

    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private PlanCelular registro;
    private ArrayList<PlanCelular> lista;

    public EscrituraArchivoSecuencial(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); // obtener los valores (objetos)
        // que tiene el archivo.
        // System.out.println(obtenerLista().size());
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo." + ioException);
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }
    
    // agrega registros al archivo
    public void establecerRegistro(PlanCelular p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
            
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            System.err.println(ex);
        }
    }

    // en el atributo listaPlanes obtenemos los registros 
    // del archivo
    public void establecerLista() {
        LecturaArchivoSecuencial l = 
                new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaPlanes();
        lista = l.obtenerListaPlanes();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<PlanCelular> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    
    // obtener registros al archivo
    public PlanCelular obtenerRegistro() {
        // System.out.println(p);
        return registro;
    }
    
    
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
    } 

}