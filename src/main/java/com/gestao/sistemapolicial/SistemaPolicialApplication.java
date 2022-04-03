package com.gestao.sistemapolicial;

import com.gestao.sistemapolicial.controller.CrimeDAO;
import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication

public class SistemaPolicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPolicialApplication.class, args);
		var crimeDao = new CrimeDAO();

		var criminoso = Criminoso.builder().nome("user1").dataNascimento(LocalDate.now()).cpf("999999").build();
		var criminoso2 = Criminoso.builder().nome("user2").dataNascimento(LocalDate.now()).cpf("999998").build();
		var criminoso3 = Criminoso.builder().nome("user3").dataNascimento(LocalDate.now()).cpf("9999997").build();

		var crime = Crime.builder().descricao("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").criminosos(Arrays.asList(criminoso, criminoso2, criminoso3)).build();

		crimeDao.principalFluxo(crime);
	}

}
