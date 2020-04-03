package com.mindhub.fulbo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Pais pais;
    @OneToOne(mappedBy = "club")
    private Tecnico tecnico;
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Jugador> jugadores;

    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClubPatrocinador> clubPatrocinadorSet;

    public Club(){}

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

    public Set<ClubPatrocinador> getClubPatrocinadorSet() {
        return clubPatrocinadorSet;
    }

    public void setClubPatrocinadorSet(Set<ClubPatrocinador> clubPatrocinadorSet) {
        this.clubPatrocinadorSet = clubPatrocinadorSet;
    }

    public static void traspaso(Jugador jugador, Club clubViejo, Club clubNuevo){
        jugador.setClub(clubNuevo);
        clubViejo.setJugadores(
                clubViejo.getJugadores().stream().filter(j -> j != jugador).collect(Collectors.toSet()));
        clubNuevo.getJugadores().add(jugador);
    }

    public Map<String,Object> clubDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("club", this.getNombre());
        dto.put("pais", this.getPais().toString());
        dto.put("tecnico",this.getTecnico() != null ? this.getTecnico().tecnicoDTO(): null );
        dto.put("jugadores", this.getJugadores().stream().map(Jugador::jugadorDTO));
        return dto;
    }
}
