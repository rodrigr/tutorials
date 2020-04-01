package com.mindhub;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Club barcelona = new Club("FC Barcelona",Pais.ESPAÑA);
        Jugador messi = new Jugador("Leonel","Messi", LocalDate.parse("1987-06-24"),10,barcelona,"delantero");
        Jugador suarez = new Jugador("Luis","Suárez", LocalDate.parse("1987-01-24"),9,barcelona,"delantero");
        Tecnico setien = new Tecnico("Quique", "Setién", LocalDate.parse("1958-09-27"),barcelona);


        barcelona.getJugadores().add(messi);
        barcelona.getJugadores().add(suarez);
        barcelona.setTecnico(setien);


        System.out.println(messi.saludar());
        System.out.println(messi.presentarse());
        System.out.println(setien.presentarse());



        Club newells = new Club("Newell's old boys",Pais.ARGENTINA);

        barcelona.setPais(Pais.CATALUNYA);

        System.out.println("------------ jugadores del Barça --------------");
        barcelona.getJugadores().forEach(jugador -> System.out.println(jugador.nombreCompleto()));

        System.out.println("------------ pase ------------------");
        Club.traspaso(messi,barcelona,newells);

        System.out.println("------------ jugadores del Barça --------------");
        barcelona.getJugadores().forEach(jugador -> System.out.println(jugador.nombreCompleto()));

        System.out.println("------------ jugadores de Newell's --------------");
        newells.getJugadores().forEach(jugador -> System.out.println(jugador.nombreCompleto()));

        
    }
}
