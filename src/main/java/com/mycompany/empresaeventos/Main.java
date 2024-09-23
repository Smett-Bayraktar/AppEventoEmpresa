/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empresaeventos;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author CETECOM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        Cliente cli = new Cliente();
        Evento eve = new Evento();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = new Date();
        Date fechaTermino = new Date();
        //variables de la clase cli
        String nombre;
        String rut;
        String telefono;
        String correo;
        String categoria;
        //variables de la clase evento
        String nombreEvento;
        int precio = 0;
        
        int menu = 0;
        System.out.println("Bienvenido!");
        do {
            System.out.println("--------- MENU ---------");
            System.out.println(" 1. Agregar Cliente");
            System.out.println(" 2. Crear Evento");
            System.out.println(" 3. Agregar Descuento");
            System.out.println(" 4. Mostrar información Evento y Cliente");
            System.out.println(" 5. Salir");
            menu = teclado.nextInt();
            teclado.nextLine();
           switch (menu){
               case 1:
                   System.out.println("INGRESE RUT CLIENTE: ");
                   rut = teclado.nextLine();
                   cli.setRut(rut);
                   System.out.println("INGRESE TELEFONO CLIENTE: ");
                   telefono = teclado.nextLine();
                   cli.setTelefono(telefono);
                   
                   do {//validacion de nombre
                        System.out.println("INGRESE NOMBRE CLIENTE: ");
                        nombre = teclado.nextLine();
                        if(!cli.validaNombre(nombre)){
                            System.out.println("NOMBRE NO VALIDO");
                        }
                    
                    } while(!cli.validaNombre(nombre));
                   cli.setNombre(nombre);
                   System.out.println("INGRESE CORREO: ");
                   correo = teclado.nextLine();
                   cli.setCorreo(correo);
                   
                   do { //validacion de categoria
                       System.out.println("INGRESE CATEGORIA N(NUEVO)/A(ANTIGUO): ");
                       categoria = teclado.nextLine().toUpperCase();
                       if (!cli.validaCategoria(categoria)) {
                           System.out.println("ERROR, CATEGORIA NO VALIDO");
                       }
                   } while (!cli.validaCategoria(categoria));
                   cli.setTipoCliente(categoria);
                   
                   break;
               case 2:
                   do {//validacion del nombre
                        System.out.println("INGRESE NOMBRE EVENTO: ");
                        nombreEvento = teclado.nextLine();
                        if(!eve.validarNombre(nombreEvento)){
                            System.out.println("NOMBRE NO VALIDO");
                        }
                    
                    } while(!eve.validarNombre(nombreEvento));
                   eve.setNombre(nombreEvento);
                   
                   do {//validacion del precio                        
                       System.out.println("INGRESE PRECIO EVENTO: ");
                       precio = teclado.nextInt();
                       teclado.nextLine();
                       if (!eve.validarPrecio(precio)) {
                           System.out.println("ERROR, PRECIO INVALIDO");
                       }
                       eve.setPrecio(precio);
                   } while (!eve.validarPrecio(precio));
                   //Validar fechas
                   do {
                       System.out.println("INGRESA FECHA INICIO DEL EVENTO: dd-MM-yyyy");
                       fechaInicio = formatoFecha.parse(teclado.nextLine());
                       eve.setFechaInicio(fechaInicio);
                       // ------------------------------------------------------------------
                       System.out.println("INGRESA FECHA TERMINO DEL EVENTO: dd-MM-yyyy");
                       fechaTermino = formatoFecha.parse(teclado.nextLine());
                       eve.setFechaTermino(fechaTermino);
                       if (!eve.validarFechas()) {
                            System.out.println("ERROR, FECHA TERMINO DEBE SER POSTERIOR A FECHA INICIO.");
                        }
                        eve.enviarCorreoRecordatorio(cli.getCorreo());
                   } while (!eve.validarFechas());
                   
                   break;
               case 3:
                   eve.descuentoEvento(cli.getTipoCliente());
                   break;
               case 4:
                   cli.mostrarDatosCliente();
                   System.out.println("-------------------------------------------------------");
                   eve.mostrarDatosEventos(cli.getTipoCliente(), cli.getNombre(), cli.getCorreo());
                   break;
               case 5:
                   System.out.println("Hasta Luego!");
                   break;
           } 
        } while (menu!=5);
        System.out.println("El programa ah finalizado");
    }
    
}
