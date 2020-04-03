package com.mindhub.fulbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class FulboApplication {

	public static void main(String[] args) {
		SpringApplication.run(FulboApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClubRepository clubRepository,JugadorRepository jugadorRepository, TecnicoRepository tecnicoRepository,PatrocinadorRepository patrocinadorRepository, ClubPatrocinadorRepository clubPatrocinadorRepository) {
		return args -> {
			//Clubes
			Club barcelona = new Club("FC Barcelona",Pais.ESPAÑA);
			Club newells = new Club("Newell's old boys",Pais.ARGENTINA);
			Club boca = new Club("Boca Juniors",Pais.ARGENTINA);
			Club river = new Club("River Plate",Pais.ARGENTINA);
			Club manchesterCity = new Club("Manchester City",Pais.INGLATERRA);
			Club manchesterUnited = new Club("Manchester United",Pais.INGLATERRA);
			Club westham = new Club("West Ham United",Pais.INGLATERRA);
			Club juventus = new Club("Juventus",Pais.ITALIA);
			Club shenhua = new Club("Shanghái Shenhua",Pais.CHINA);
			Club corinthians = new Club("Corinthians",Pais.BRASIL);

			//Jugadores
			Jugador messi = new Jugador("Leonel","Messi", LocalDate.parse("1987-06-24"),10,barcelona,Posicion.DEL, 1.7);
			Jugador suarez = new Jugador("Luis","Suárez", LocalDate.parse("1987-01-24"),9,barcelona,Posicion.DEL,1.82);

			barcelona.getJugadores().add(messi);
			barcelona.getJugadores().add(suarez);

			Jugador tevez = new Jugador("Carlos","Tévez", LocalDate.parse("1984-02-05"),10,boca,Posicion.DEL,1.73);
			Jugador abila = new Jugador("Ramón","Ábila", LocalDate.parse("1989-10-14"),9,boca,Posicion.DEL,1.80);
			Jugador andrada = new Jugador("Esteban","Andrada", LocalDate.parse("1991-01-26"),1,boca,Posicion.ARQ,1.93);
			Jugador mas = new Jugador("Emmanuel","Mas", LocalDate.parse("1989-01-15"),3,boca,Posicion.DEF,1.8);
			Jugador salvio = new Jugador("Eduardo","Salvio", LocalDate.parse("1990-07-13"),11,boca,Posicion.MED,1.71);

			boca.getJugadores().add(tevez);
			boca.getJugadores().add(abila);
			boca.getJugadores().add(andrada);
			boca.getJugadores().add(mas);
			boca.getJugadores().add(salvio);




			//Técnicos
			Tecnico setien = new Tecnico("Quique", "Setién", LocalDate.parse("1958-09-27"),barcelona);
			Tecnico russo = new Tecnico("Miguel Angel", "Russo", LocalDate.parse("1958-09-27"),boca);
			Tecnico gallardo = new Tecnico("Marcelo", "Gallardo", LocalDate.parse("1958-09-27"),river);
			Tecnico kudelka = new Tecnico("Frank Darío", "Kudelka", LocalDate.parse("1958-09-27"),newells);




			clubRepository.save(barcelona);
			clubRepository.save(boca);
			clubRepository.save(river);
			clubRepository.save(newells);
			clubRepository.save(manchesterCity);
			clubRepository.save(manchesterUnited);
			clubRepository.save(westham);
			clubRepository.save(juventus);
			clubRepository.save(shenhua);
			clubRepository.save(corinthians);


			tecnicoRepository.save(setien);
			tecnicoRepository.save(russo);
			tecnicoRepository.save(gallardo);
			tecnicoRepository.save(kudelka);

			tevez.addClubAnterior(boca);
			tevez.addClubAnterior(corinthians);
			tevez.addClubAnterior(westham);
			tevez.addClubAnterior(manchesterCity);
			tevez.addClubAnterior(manchesterUnited);
			tevez.addClubAnterior(juventus);
			tevez.addClubAnterior(shenhua);

			jugadorRepository.save(tevez);

			Patrocinador patrocinador1 = new Patrocinador("Qatar Airways");
			Patrocinador patrocinador2 = new Patrocinador("AXION energy");
			Patrocinador patrocinador3 = new Patrocinador("AXE");

			patrocinadorRepository.save(patrocinador1);
			patrocinadorRepository.save(patrocinador2);
			patrocinadorRepository.save(patrocinador3);

			ClubPatrocinador clubPatrocinador1 = new ClubPatrocinador(boca, patrocinador1);
			ClubPatrocinador clubPatrocinador2 = new ClubPatrocinador(boca, patrocinador2);
			ClubPatrocinador clubPatrocinador3 = new ClubPatrocinador(boca, patrocinador3);
			ClubPatrocinador clubPatrocinador4 = new ClubPatrocinador(barcelona, patrocinador1);

			clubPatrocinadorRepository.save(clubPatrocinador1);
			clubPatrocinadorRepository.save(clubPatrocinador2);
			clubPatrocinadorRepository.save(clubPatrocinador3);
			clubPatrocinadorRepository.save(clubPatrocinador4);

		};
	}

}
