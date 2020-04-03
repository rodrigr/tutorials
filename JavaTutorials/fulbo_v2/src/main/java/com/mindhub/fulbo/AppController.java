package com.mindhub.fulbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    TecnicoRepository tecnicoRepository;

    @GetMapping("/jugadores")
    public List<Map<String,Object>> getJugadores(){
        return jugadorRepository.findAll().stream().map(Jugador::jugadorDTO).collect(Collectors.toList());
    }

    @GetMapping("/jugadoresII")
    public List<Map<String,Object>> getJugadoresII(){
        List<Map<String,Object>> jugadoresDTOs = new ArrayList<>();
        jugadorRepository.findAll().forEach(jugador -> jugadoresDTOs.add(jugador.jugadorDTO()));
        return jugadoresDTOs;
    }

    @GetMapping("/jugadores/masAlto")
    public Map<String,Object> getJugadorMasAlto(){
        Jugador jugadorMasAlto = jugadorRepository.findAll().stream().max(Comparator.comparing(Jugador::getAltura)).orElse(null);
        if(jugadorMasAlto != null){
            return jugadorMasAlto.jugadorDTO();
        }else{
            return null;
        }
    }

    @GetMapping("/jugadores/masBajo")
    public Map<String,Object> getJugadorMasBajo(){
        Jugador jugadorMasBajo = jugadorRepository.findAll().stream().min(Comparator.comparing(Jugador::getAltura)).orElse(null);
        if(jugadorMasBajo != null){
            return jugadorMasBajo.jugadorDTO();
        }else{
            return null;
        }
    }

    @GetMapping("jugadores/alturas")
    public DoubleStream getAlturas(){
        return jugadorRepository.findAll().stream().mapToDouble(Jugador::getAltura);
    }

    @GetMapping("/clubes/{pais}")
    public List<Map<String,Object>> getClubesPorPais(@PathVariable String pais){
        return clubRepository.findAll()
                .stream()
                .filter(club -> club.getPais().toString().equals(pais.toUpperCase()))
                .map(Club::clubDTO).collect(Collectors.toList());
    }

    @GetMapping("/clubes/{clubId}/tieneJugadoresAltos")
    public boolean tieneJugadoresAltos(@PathVariable long clubId){
        Club club = clubRepository.findById(clubId).orElse(null);
        if(club != null){
            return club.getJugadores().stream().anyMatch(jugador -> jugador.getAltura() >= 1.9);
        }else{
            return false;
        }

    }

    @GetMapping("/clubes/tieneJugadoresAltos")
    public List<Map<String,Object>> paisTieneJugadoresAltos(){
        return clubRepository.findAll()
                .stream()
                .filter(club -> club.getJugadores().stream().anyMatch(jugador -> jugador.getAltura() >= 1.9))
                .map(Club::clubDTO).collect(Collectors.toList());

    }

    @GetMapping("/clubes/jugadores")
    public List<Map<String,Object>> getAllJugadores(){
        return clubRepository.findAll().stream().flatMap(club -> club.getJugadores().stream().map(Jugador::jugadorDTO)).collect(Collectors.toList());
    }

}
