package com.mindhub.fulbo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "patrocinador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClubPatrocinador> clubPatrocinadorSet;

    public Patrocinador(){}

    public Patrocinador(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<ClubPatrocinador> getClubPatrocinadorSet() {
        return clubPatrocinadorSet;
    }

    public void setClubPatrocinadorSet(Set<ClubPatrocinador> clubPatrocinadorSet) {
        this.clubPatrocinadorSet = clubPatrocinadorSet;
    }
}
