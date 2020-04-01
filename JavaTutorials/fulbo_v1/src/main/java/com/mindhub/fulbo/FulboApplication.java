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
	public CommandLineRunner initData(ClubRepository clubRepository,JugadorRepository jugadorRepository, TecnicoRepository tecnicoRepository) {
		return args -> {

			Club barcelona = new Club("FC Barcelona",Pais.ESPAÑA);
			Club newells = new Club("Newell's old boys",Pais.ARGENTINA);
			Club boca = new Club("Boca Juniors",Pais.ARGENTINA);
			Club river = new Club("River Plate",Pais.ARGENTINA);
			Jugador messi = new Jugador("Leonel","Messi", LocalDate.parse("1987-06-24"),10,barcelona,"delantero");
			Jugador suarez = new Jugador("Luis","Suárez", LocalDate.parse("1987-01-24"),9,barcelona,"delantero");
			Tecnico setien = new Tecnico("Quique", "Setién", LocalDate.parse("1958-09-27"),barcelona);
			Tecnico russo = new Tecnico("Miguel Angel", "Russo", LocalDate.parse("1958-09-27"),boca);
			Tecnico gallardo = new Tecnico("Marcelo", "Gallardo", LocalDate.parse("1958-09-27"),river);
			Tecnico kudelka = new Tecnico("Frank Darío", "Kudelka", LocalDate.parse("1958-09-27"),newells);


			barcelona.getJugadores().add(messi);
			barcelona.getJugadores().add(suarez);

			clubRepository.save(barcelona);
			clubRepository.save(boca);
			clubRepository.save(river);
			clubRepository.save(newells);


			tecnicoRepository.save(setien);
			tecnicoRepository.save(russo);
			tecnicoRepository.save(gallardo);
			tecnicoRepository.save(kudelka);


		};
	}

}
