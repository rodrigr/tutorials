package com.mindhub.fulbo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Tecnico extends Persona {
    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public Tecnico(){}

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

    public Map<String,Object> tecnicoDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("nombre", this.getNombre());
        dto.put("apellido", this.getApellido());
        dto.put("fecha_nacimiento", this.getFecha_nacimiento());
        return dto;
    }
}
