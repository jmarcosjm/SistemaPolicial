package com.gestao.sistemapolicial;

import com.gestao.sistemapolicial.controller.ConnectionPool;
import com.gestao.sistemapolicial.enums.TipoArma;
import com.gestao.sistemapolicial.model.entity.Arma;
import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import com.gestao.sistemapolicial.model.entity.Vitima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication

public class SistemaPolicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPolicialApplication.class, args);
		ConnectionPool.initPool();
		var crimeDao = ConnectionPool.crimeDAO;

		var arma = Arma.builder()
				.numeroRegistro(113)
				.descricao("arma top")
				.tipoArma(TipoArma.FOGO)
				.build();

		var arma1 = Arma.builder()
				.numeroRegistro(124)
				.descricao("arma top 11")
				.tipoArma(TipoArma.FOGO)
				.build();

		var listArmas = new ArrayList<Arma>();

		listArmas.add(arma);
		listArmas.add(arma1);

		var vitima1 = Vitima.builder()
				.cpf("9992388321")
				.nome("Pedro")
				.dataNascimento(LocalDate.now())
				.build();

		var vitima2 = Vitima.builder()
				.cpf("999238833")
				.nome("Pedro")
				.dataNascimento(LocalDate.now())
				.build();

		var listVitimas = new ArrayList<Vitima>();

		listVitimas.add(vitima1);
		listVitimas.add(vitima2);

		var criminoso = Criminoso.builder()
				.nome("Joao Marcos")
				.dataNascimento(LocalDate.now())
				.cpf("139923235")
				.build();

		var criminoso2 = Criminoso.builder()
				.nome("Leo Pss")
				.dataNascimento(LocalDate.now())
				.armas(listArmas)
				.vitimas(listVitimas)
				.cpf("01001231295").build();

		var criminoso3 = Criminoso.builder()
				.nome("Vitor C")
				.dataNascimento(LocalDate.now())
				.vitimas(listVitimas)
				.cpf("12389192445").build();

		var crime = Crime.builder().descricao("crime o crime").criminosos(Arrays.asList(criminoso, criminoso2, criminoso3)).build();

		//crimeDao.principalFluxo(crime);

		ConnectionPool.criminosoDAO.deleteById(21);
	}

}
