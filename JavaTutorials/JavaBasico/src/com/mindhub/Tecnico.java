package com.mindhub;

import java.time.LocalDate;

public class Tecnico extends Persona {
    private Club club;

    public Tecnico(String nombre, String apellido, LocalDate fecha_nacimiento, Club club) {
        super(nombre, apellido, fecha_nacimiento);
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String presentarse() {
        return "Hola! mi nombre es " + this.nombreCompleto() + " y soy técnico de " + this.getClub().getNombre();
    }
}
