/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empresaeventos;

/**
 *
 * @author CETECOM
 */
public class Cliente {
    private String nombre;
    private String rut;
    private String telefono;
    private String tipoCliente;
    private String correo;
    //private Evento evento;

    public Cliente() {
    }

    public Cliente(String nombre, String rut, String telefono, String tipoCliente, String correo/*,Evento evento*/) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
        this.correo = correo;
        //this.evento = evento;
    }

    

    /*public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //Ahora vamos con los metodos
    public boolean validaNombre(String nombre){
        return !nombre.equals("");
    }
    
    public boolean validaCategoria(String categoria){
        return categoria.equals("N") || categoria.equals("A") || categoria.equals("NUEVO") || categoria.equals("ANTIGUO");
    }
    
    public void mostrarDatosCliente(){
        System.out.println("------------- DATOS DEL CLIENTE -------------");
        System.out.println("NOMBRE CLIENTE: " +this.nombre);
        System.out.println("RUT CLIENTE: " +this.rut);
        System.out.println("TELEFONO CLIENTE: " +this.telefono);
        System.out.println("CORREO DE CLIENTE: " +this.correo);
        if (this.tipoCliente.equals("N")) {
            System.out.println("TIPO CLIENTE: NUEVO");
        }
        else if (this.tipoCliente.equals("A")){
            System.out.println("TIPO DE CLIENTE: ANTIGUO");
        }
    }
    
}
