package com.mindhub;

import java.time.LocalDate;

public abstract class Persona {
    //Atributos o propiedades de los objetos pertencientes a la clase persona
    private String nombre;
    private String apellido;
    private int documento;
    private LocalDate fecha_nacimiento;

    //Constructor: indica con que propiedades se debe instanciar (inicializar) un objeto perteneciente a esta clase
    //Puedo tener varios constructores
    public Persona(String nombre, String apellido, int documento, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Persona(String nombre, String apellido, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    //Getter & Setters: son métodos que permiten obtener un atributo del objeto (getter) o modificarlo (setter)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }


    //Otros métodos o comportamientos de los objetos pertencientes a la clase persona
    public String saludar(){
        return "Hola!";
    }

    public String nombreCompleto(){
        return this.getNombre() + " " + this.getApellido();
    }

    //los métodos abstractos permiten que una clase hija pueda modificarlos
    public abstract String presentarse();


}
