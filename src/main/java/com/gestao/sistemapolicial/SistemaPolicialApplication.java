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

		var arma2 = Arma.builder()
				.numeroRegistro(992)
				.descricao("facão")
				.tipoArma(TipoArma.BRANCA)
				.build();

		var arma3 = Arma.builder()
				.numeroRegistro(777)
				.descricao("carambit")
				.tipoArma(TipoArma.BRANCA)
				.build();

		var listArmas = new ArrayList<Arma>();

		listArmas.add(arma);
		listArmas.add(arma1);
		listArmas.add(arma2);
		listArmas.add(arma3);

		var vitima1 = Vitima.builder()
				.cpf("99923123")
				.nome("Bonfim")
				.dataNascimento(LocalDate.now())
				.build();

		var vitima2 = Vitima.builder()
				.cpf("93883311")
				.nome("Vitin")
				.dataNascimento(LocalDate.now())
				.build();

		var listVitimas = new ArrayList<Vitima>();

		listVitimas.add(vitima1);
		listVitimas.add(vitima2);

		var criminoso = Criminoso.builder()
				.nome("JJ")
				.dataNascimento(LocalDate.now())
				.cpf("00022")
				.build();

		var criminoso2 = Criminoso.builder()
				.id(14)
				.nome("Otamendi")
				.dataNascimento(LocalDate.now())
				.armas(listArmas)
				.vitimas(listVitimas)
				.cpf("3999123122").build();

		var criminoso3 = Criminoso.builder()
				.nome("Ruan")
				.dataNascimento(LocalDate.now())
				.vitimas(listVitimas)
				.cpf("999128").build();

		var crime = Crime.builder().id(24).descricao("crime atualizado").criminosos(Arrays.asList(criminoso, criminoso2, criminoso3)).build();

		var crime24 = crimeDao.update(24);

		crime24.setDescricao("crime atualizado");
		var list = crime24.getCriminosos();
		list.add(criminoso2);
		crime24.setUpdate(true);

		crimeDao.principalFluxo(crime24);
	}

}
