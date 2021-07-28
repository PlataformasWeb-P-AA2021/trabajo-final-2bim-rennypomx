/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

import Paquete2.PlanCelular;
import Paquete2.PlanPostPagoMegas;
import Paquete2.PlanPostPagoMinutos;
import Paquete2.PlanPostPagoMinutosMegas;
import Paquete2.PlanPostPagoMinutosMegasEconomico;
import Paquete3.EscrituraArchivoSecuencial;
import Paquete3.LecturaArchivoSecuencial;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Principal {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<PlanCelular> lista = new ArrayList();
    String nomArchivo = "planes.data";
    EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(nomArchivo);//para

    boolean salida = true;
    int opcionIngreso;
    int ingresarMostrar;
    do {
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nomArchivo);// 
        System.out.println("====EMPRESA TELEFONIA CELULAR====");
        System.out.printf("Eliga la opcion que desea:\n"
                + "1.Ingresar Planes\n"
                + "2.Mostrar Planes\n"
               + "3.Salir\n ");
        ingresarMostrar = sc.nextInt();
        
        if (ingresarMostrar == 1) {
            System.out.println("Seleccione el plan que desea ingresar:");
            System.out.printf("1. Si desea ingresar un "
                    + "Plan Post Pago Minutos \n"
                    + "2. Si desea ingresar un Plan Post Pago Megas\n"
                    + "3. Si desea ingresar un "
                    + "Plan Post Pago Minutos Megas\n"
                    + "4. Si desea ingresar un "
                    + "Plan Post Pago Minutos Megas Economico\n"
            );
            sc.nextLine();
            opcionIngreso = sc.nextInt();
            sc.nextLine();
            //PLAN CELULAR  
            System.out.println("----- Propietario ------");
            System.out.println("Ingrese el nombre");
            String nombre = sc.nextLine();
            System.out.println("Ingres el apellido");
            String apell = sc.nextLine();
            System.out.println("Ingrese la identificacion");
            String iden = sc.nextLine();

            System.out.println("Ingrese la ciudad del propietario");
            String ciu = sc.nextLine();
            System.out.println("Ingrese la marca del celular");
            String mar = sc.nextLine();
            System.out.println("Ingrese el número del celular");
            String num = sc.nextLine();

            System.out.println("Ingrese el modelo del celular");
            String mod = sc.nextLine();

            Persona pr = new Persona(nombre, apell, iden);

            switch (opcionIngreso) {
                case 1:
                    System.out.println("====Plan Post Pago Minutos====");
                    System.out.println("Ingrese los minutos nacionales");
                    double numNac = sc.nextDouble();
                    System.out.println("Ingrese el costo minuto Nacional");
                    double cosNac = sc.nextDouble();
                    System.out.println("Ingrese minutos internacionales");
                    double minInt = sc.nextDouble();
                    System.out.println("Ingrese el costo de minutos Internacionales");
                    double cosInt = sc.nextDouble();
                    
                    PlanPostPagoMinutos p1 = new PlanPostPagoMinutos(pr,
                            mar, ciu, mod, num, numNac, cosNac, minInt, cosInt);
                    lista.add(p1);

                    break;
                case 2:
                    System.out.println("=====Plan Post Pago Megas=====");
                    System.out.println("Ingrese las megas expresado en Gigas");
                    double megGig = sc.nextDouble();
                    System.out.println("Ingrese el costo de gigas");
                    double cosGig = sc.nextDouble();
                            
                    System.out.println("Ingrese la tarifa base");
                    double tarBase = sc.nextDouble();
                    PlanPostPagoMegas p2 = new PlanPostPagoMegas(pr,
                            mar, ciu, mod, num, megGig, cosGig, tarBase);
                    lista.add(p2);
                    break;
                case 3:
                    System.out.println("====Plan Post Pago Minutos Megas====");
                    System.out.println("Ingrese el numero de minutos"
                            + "que consume");
                    double min = sc.nextDouble();
                    System.out.println("Ingrese el costo de minutos de "
                            + "su Plan");
                    double costoMin = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese las megas expresado en Gigas");
                    double megas = sc.nextDouble();

                    System.out.println("Ingrese el Costo por cada Gigas");
                    double costo = sc.nextDouble();

                    PlanPostPagoMinutosMegas p3 = new PlanPostPagoMinutosMegas(pr, mar, ciu,
                            mod, num, min, costoMin, megas, costo);
                    lista.add(p3);
                    break;
                case 4:
                    System.out.println("====Plan Post Pago Minutos Megas Economico====");
                    System.out.println("Ingrese el numero de minutos"
                            + "que consume");
                    double min2 = sc.nextDouble();
                    System.out.println("Ingrese el costo de minutos de "
                            + "su Plan");
                        double costoMin2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese las megas expresado en Gigas");
                    double megas2 = sc.nextDouble();
                   
                    System.out.println("Ingrese el Costo por cada Gigas");
                    double costo2 = sc.nextDouble();
                    PlanPostPagoMinutosMegasEconomico p4 = new PlanPostPagoMinutosMegasEconomico(pr,
                            mar, ciu, mod, num, min2, costoMin2,
                            megas2, costo2, 0.10);
                    lista.add(p4);
                    break;

                default:
                    System.err.println("Eligio una opcion fuera del "
                            + "rango(1-4)");
            }

            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setPagomensual();
            }
            //Se registra todos los datos obtenidos
            for (int i = 0; i < lista.size(); i++) {
                archivo.establecerRegistro(lista.get(i));
                archivo.establecerSalida();
            }

        } else {
            if (ingresarMostrar == 2) {
                System.out.println("Que lista desea mostrar:");
                System.out.printf("1.Mostrar lista de "
                        + "Plan Post Pago Minutos\n"
                        + "2.Mostrar lista de Plan Post Pago Megas\n"
                        + "3.Mostrar lista de Plan Post "
                        + "Pago Minutos Megas\n"
                        + "4.Mostrar lista de Plan Post "
                        + "Pago Minutos Megas Economico\n"
                        + "5.Mostrar lista de Todos Los Planes\n");
                opcionIngreso = sc.nextInt();
                lectura.establecerListaPlanes();// lee todo mi archico 
                int datos = lectura.obtenerListaPlanes().size();// una variable para almacenar el tamaño de la lista
                    
                if (datos != 0) {
                    switch (opcionIngreso) {
                        case 1:
                            int contador = 0;
                                for (int i = 0; i < lectura.obtenerListaPlanes().size(); i++) {
                                   
                                    String namePackage
                                            = lectura.obtenerListaPlanes().get(i).getClass().getName();
                                         contador = contador +1;
                                        System.out.print("\tPLAN POST PAGO MINUTOS");
                                        System.out.println(lectura.obtenerListaPlanes().get(i));
                                }
                                if (contador == 0) {
                                    System.out.println("No hay datos que mostrar");

                                }

                            break;
                        case 2:
                            contador =0;
                            for (int i = 0; i < lectura.obtenerListaPlanes().size(); i++) {
                                String namePackage = lectura.obtenerListaPlanes().get(i).getClass().getName();
                                    System.out.print("\tPLAN POST PAGO MEGAS");
                                    System.out.println(lectura.obtenerListaPlanes().get(i));
                                    contador = contador +1; 
                            }
                            if (contador == 0) {
                                System.out.println("No hay datos que mostrar");

                            }

                                break;
                        case 3:
                                contador =0; 
                                
                                for (int i = 0; i < lectura.obtenerListaPlanes().size(); i++) {
                                    String namePackage = lectura.obtenerListaPlanes().get(i).getClass().getName();
                                        System.out.print("\tPLAN POST PAGO MINUTOS MEGAS\n");
                                        System.out.println(lectura.obtenerListaPlanes().get(i));   
                                        contador = contador +1;   
                                }
                                if (contador == 0) {
                                    System.out.println("No hay datos que mostrar");

                                }
                                break;
                            case 4:
                                 contador =0;
                                for (int i = 0; i < lectura.obtenerListaPlanes().size(); i++) {
                                    String namePackage = lectura.obtenerListaPlanes().get(i).getClass().getName(); 
                                        System.out.print("\tPLAN POST PAGO MINUTOS MEGAS ECONOMICO");
                                        System.out.println(lectura.obtenerListaPlanes().get(i));
                                        contador = contador +1;
                                }
                                if (contador == 0) {
                                    System.out.println("No hay datos que mostrar");

                                }
                                break;
                            case 5:

                                System.out.println(lectura);

                                break;
                           
                            default:
                                System.err.println("Eligio una opcion fuera del "
                                        + "rango(1-5)");
                        }

                    } else {
                        System.out.println("No existen datos que mostrar");
                    }

                } else if (ingresarMostrar == 3) {
                    salida = false;
                    archivo.cerrarArchivo();
                    lectura.cerrarArchivo();
                    System.out.println("\tGracias por registrarse");
                } else {
                    System.err.println("Eligio una opcion fuera del "
                            + "rango(1-3)");
                }

            }
        } while (salida);
    }
}
