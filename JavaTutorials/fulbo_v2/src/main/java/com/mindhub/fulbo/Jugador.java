package com.mindhub.fulbo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

//la palabra extends indica que la clase Jugador hereda los atributos y métodos de la clase Persona
@Entity
public class Jugador extends Persona {
    private int numero;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    @Enumerated(EnumType.STRING)
    private Posicion posicion;

    @ElementCollection
    @CollectionTable(name = "trayectoria")
    private List<Club> clubesAnteriores;

    private double altura;

    public Jugador(){}

    public Jugador(String nombre, String apellido, LocalDate fecha_nacimiento, int numero, Club club, Posicion posicion, double altura) {
        //la funcion super() hace referencia al constructor de la clase madre (Persona) y lleva como argumento los datos que deben
        //ser llenados para cumplir con el constructor de Persona
        super(nombre, apellido, fecha_nacimiento);
        this.numero = numero;
        this.club = club;
        this.posicion = posicion;
        this.clubesAnteriores = new LinkedList<>();
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public List<Club> getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void addClubAnterior(Club club){
        this.clubesAnteriores.add(club);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //la anotación @Override indica que vamos a sobrescribir un método abstracto de la clase madre (polimorfismo)
    @Override
    public String presentarse() {
        return "Hola! Mi nombre es " + this.nombreCompleto() + " y soy " + this.getPosicion() + " de " + this.getClub().getNombre();
    }

    public Map<String,Object> jugadorDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("nombre", this.getNombre());
        dto.put("apellido", this.getApellido());
        dto.put("fecha_nacimiento", this.getFecha_nacimiento());
        dto.put("altura",this.getAltura());
        return dto;
    }
}
