package com.mindhub;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Club {
    private String nombre;
    private Pais pais;
    private Tecnico tecnico;
    private Set<Jugador> jugadores;

    public Club(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.jugadores = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public static void traspaso(Jugador jugador, Club clubViejo, Club clubNuevo){
        jugador.setClub(clubNuevo);
        clubViejo.setJugadores(
                clubViejo.getJugadores().stream().filter(j -> j != jugador).collect(Collectors.toSet()));
        clubNuevo.getJugadores().add(jugador);
    }
}
