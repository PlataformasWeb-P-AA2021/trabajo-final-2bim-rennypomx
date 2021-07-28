/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete3;
import Paquete2.PlanCelular;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;


/**
 *
 * @author Renny
 */
public class LecturaArchivoSecuencial {

    private ObjectInputStream entrada;
    private ArrayList<PlanCelular> planes;
    private String nombreArchivo;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");
               
            } // fin de catch
        }
    } 

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPlanes() {
        // 
        planes = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());

        while (true) {
            try {
                
                Object registro = entrada.readObject();
                planes.add((PlanCelular)registro);
            } catch (EOFException endOfFileException) {
                return; // se llegó al fin del archivo

            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto: " + ex);
            } catch (Exception ex) {
                // System.err.println("No hay datos en el archivo: " + ex);
                break;
            }
        }

    }

    public ArrayList<PlanCelular> obtenerListaPlanes() {
        return planes;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        
        String cadena = "\t==== LISTA DE PLANES ====\n";
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            cadena = String.format("%s%d) === %s ===  %s\n", cadena, 
                    i+1, p.getClass().getSimpleName(), p);
        }
        // mostramos el titulo1 addemas el nombre de la clase ademas del objeto por cada iteracion 

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
           System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}