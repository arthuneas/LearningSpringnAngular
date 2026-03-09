package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.CalculosApplication;

@SpringBootTest(classes = CalculosApplication.class)
public class CalculosServiceTest {

	@Autowired
	CalculosService calculosService; // fazer autowired com a classe testada

	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			lista.add(i);
		}

		int retorno = this.calculosService.somar(lista);

		// fazer comparação de teste
		assertEquals(15, retorno);
	}

	@Test
	// testa a capacidade do programa de ignorar valores nulos
	void cenario02() {
		List<Integer> lista = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			lista.add(i);
		}

		// adiciona nulo a uma lista de inteiros
		lista.add(null);

		// int retorno = this.calculosService.somar(lista);

		// aqui, se o retorno na função der um problema, ele passa no teste.
		assertThrows(Exception.class, () -> {
			int retorno = this.calculosService.somar(lista);
		});

	}

}
