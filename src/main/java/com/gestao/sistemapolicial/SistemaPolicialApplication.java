package com.gestao.sistemapolicial;

import com.gestao.sistemapolicial.controller.CrimeDAO;
import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication

public class SistemaPolicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPolicialApplication.class, args);
		var crimeDao = CrimeDAO.builder().build();

		var criminoso = Criminoso.builder().nome("user").cpf("121923192").build();

		var list = new ArrayList<Criminoso>();

		list.add(criminoso);

		var crime = Crime.builder().criminosos(list).build();

		crimeDao.principalFluxo(crime);
	}

}
