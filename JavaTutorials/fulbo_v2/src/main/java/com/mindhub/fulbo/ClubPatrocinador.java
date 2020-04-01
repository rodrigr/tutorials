package com.mindhub.fulbo;

import javax.persistence.*;

@Entity
public class ClubPatrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "patrocinador_id")
    private Patrocinador patrocinador;

    public ClubPatrocinador(){}

    public ClubPatrocinador(Club club, Patrocinador patrocinador) {
        this.club = club;
        this.patrocinador = patrocinador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }
}
