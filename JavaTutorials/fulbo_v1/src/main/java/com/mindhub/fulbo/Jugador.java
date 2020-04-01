package com.mindhub.fulbo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

//la palabra extends indica que la clase Jugador hereda los atributos y métodos de la clase Persona
@Entity
public class Jugador extends Persona {
    private int numero;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    private String posicion;

    public Jugador(){}

    public Jugador(String nombre, String apellido, LocalDate fecha_nacimiento, int numero, Club club, String posicion) {
        //la funcion super() hace referencia al constructor de la clase madre (Persona) y lleva como argumento los datos que deben
        //ser llenados para cumplir con el constructor de Persona
        super(nombre, apellido, fecha_nacimiento);
        this.numero = numero;
        this.club = club;
        this.posicion = posicion;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
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
        return dto;
    }
}
