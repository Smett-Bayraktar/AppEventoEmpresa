/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empresaeventos;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author CETECOM
 */
public class Evento {
    private String nombre;
    private Date fechaInicio;
    private Date fechaTermino;
    private int precio;
    private double valorDescuento;
    private double valorFinal;
    private Cliente cliente;

    public Evento() {
    }

    public Evento(String nombre, Date fechaInicio, Date fechaTermino, int precio, double valorDescuento, double valorFinal, Cliente cliente) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.precio = precio;
        this.valorDescuento = valorDescuento;
        this.valorFinal = valorFinal;
        this.cliente = cliente;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public void setValorDescuento(int valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Cliente getCliente() {
      return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    //Ahora vendran los metodos
    public boolean validarNombre(String nombre){
        return !nombre.equals("");
    }
    
    public boolean validarPrecio(int precio){
        return precio>=150000;
    }
    
    public boolean validarFechas() {
        return !fechaTermino.before(fechaInicio);
    }
    
    public void enviarCorreo(String correo/*Date fechaIni, Date fechaTerm*/){
        System.out.println("Se ha mandado el mensaje de aviso al siguiente correo: "+correo);
    }
    
    public void enviarCorreoRecordatorio(String correo) {
        if (fechaInicio != null && correo != null) {
            Date hoy = new Date();
        
            long diferenciaMillis = fechaInicio.getTime() - hoy.getTime();

            long diferenciaDias = diferenciaMillis / (1000 * 60 * 60 * 24);

            if (diferenciaDias == 1) {
            
                enviarCorreo(correo);
            }
        }
    }
    
    
    public void descuentoEvento(String categoria){
        if (this.precio >= 1000000 || categoria.equals("N") || categoria.equals("NUEVO")) {
            this.valorDescuento = this.precio*0.5;
            this.valorFinal = this.precio - this.valorDescuento;
            System.out.println("DESCUENTO APLICADO");
        }
        else{
            this.valorDescuento = 0;
            this.valorFinal = this.precio - this.valorDescuento;
            System.out.println("DESCUENTO NO APLICADO");
        }
    }
    
    public void mostrarDatosEventos(String categoria, String nombreCliente, String correoCliente){
        System.out.println("------------- DATOS DEL EVENTO -------------");
        System.out.println("NOMBRE DE EVENTO: " +this.nombre);
        System.out.println("PRECIO INICIAL EVENTO: " +this.precio);
        if (this.precio >= 1000000 || categoria.equals("N") || categoria.equals("NUEVO")) {
            System.out.println("VALOR CON DESCUENTO: " +this.valorFinal);
            System.out.println("PORCENTAJE DEL DESCUENTO: 50%" );
        }
        else{
        System.out.println("VALOR CON DESCUENTO: " +this.valorFinal);
        System.out.println("PORCENTAJE DEL DESCUENTO: 0%");
        }
        System.out.println("FECHA INICIO: " + new SimpleDateFormat("dd-MM-yyyy").format(fechaInicio));
        System.out.println("FECHA TERMINO: " + new SimpleDateFormat("dd-MM-yyyy").format(fechaTermino));
        System.out.println("NOMBRE DEL CLIENTE DEL EVENTO: "+nombreCliente);
        System.out.println("CORREO DEL CLIENTE DEL EVENTO: "+correoCliente);
    }
}