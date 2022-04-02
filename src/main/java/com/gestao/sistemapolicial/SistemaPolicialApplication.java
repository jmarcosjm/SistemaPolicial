package com.gestao.sistemapolicial;

import com.gestao.sistemapolicial.controller.ArmaDAO;
import com.gestao.sistemapolicial.model.entity.Arma;
import com.gestao.sistemapolicial.service.ArmaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SistemaPolicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPolicialApplication.class, args);
		ArmaDAO controller = new ArmaDAO();
		controller.inserirArma(new Arma());
	}

}
