package com.mindhub.fulbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    TecnicoRepository tecnicoRepository;

//    @GetMapping("/clubes/{pais}")
//    public List<Club> getClubesPorPais(@PathVariable String pais){
//        return clubRepository.findAll()
//                .stream()
//                .filter(club -> club.getPais().toString().equals(pais.toUpperCase())).collect(Collectors.toList());
//    }

    @GetMapping("/clubes/{pais}")
    public List<Map<String,Object>> getClubesPorPais(@PathVariable String pais){
        return clubRepository.findAll()
                .stream()
                .filter(club -> club.getPais().toString().equals(pais.toUpperCase()))
                .map(Club::clubDTO).collect(Collectors.toList());
    }
}
