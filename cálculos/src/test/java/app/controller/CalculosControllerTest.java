package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.CalculosApplication;
import app.entity.Entrada;
import app.entity.Saida;
import app.repository.CalculosRepository;

@SpringBootTest(classes = CalculosApplication.class)
public class CalculosControllerTest {

	@Autowired
	CalculosController calculosController;

	@MockitoBean
	CalculosRepository calculosRepository;

	// RETIRAMOS ELEMENTOS REPETITIVOS E DEIXA MAIS LIMPO
	@BeforeEach
	void setup() {
		List<Saida> lista = new ArrayList<>();
		lista.add(new Saida(1L, 5, 10));
		lista.add(new Saida(2L, 5, 10));
		lista.add(new Saida(3L, 5, 10));

		Saida saida = new Saida(1L, 50, 100);

		when(calculosRepository.findAll()).thenReturn(lista);
		when(calculosRepository.findById(1L)).thenReturn(Optional.of(saida));
	}

	// TESTE COM MOCK
	@Test
	void cenario01() {
		setup();
		ResponseEntity<List<Saida>> retorno = this.calculosController.findAll();
		assertEquals(3, retorno.getBody().size());
	}

	// TESTE DE INTEGRAÇÃO SEM MOCK
	@Test
	void cenario02() {

		List<Integer> lista = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			lista.add(i);
		}

		Entrada entrada = new Entrada();
		entrada.setLista(lista);

		ResponseEntity<Saida> retorno = this.calculosController.calcular(entrada);

		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());

		assertEquals(15, retorno.getBody().getSoma());

	}

	@Test
	void cenario03() {
		setup();
		ResponseEntity<List<Saida>> retorno = this.calculosController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}

	@Test
	void cenario04() {
		ResponseEntity<Saida> retorno = this.calculosController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}

	@Test
	void cenario05() {
		ResponseEntity<Saida> retorno = this.calculosController.findById(1L);
		assertEquals(50, retorno.getBody().getSoma());
	}

}
