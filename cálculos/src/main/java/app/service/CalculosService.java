package app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Saida;
import app.repository.CalculosRepository;

@Service
public class CalculosService {

	@Autowired
	CalculosRepository calculosRepository;

	public int somar(List<Integer> lista) {

		int soma = 0;

		if (lista != null && !lista.isEmpty()) {

			for (Integer numero : lista) {

				soma += numero;

			}
		}

		return soma;
	}

	public int buscarMaiorNumero(List<Integer> lista) {

		int maior = 0;

		if (lista != null && !lista.isEmpty()) {
			maior = Collections.max(lista);
		}

		return maior;
	}

	public Saida calcular(Entrada entrada) {
		Saida saida = new Saida();

		// Guarda os valores calculados no objeto que será retornado
		saida.setSoma(this.somar(entrada.getLista()));
		saida.setMaiorNumeroLista(this.buscarMaiorNumero(entrada.getLista()));

		// saida = this.calculosRepository.save(saida);

		return saida;
	}

	public List<Saida> findAll() {
		return this.calculosRepository.findAll();
	}

	public Saida findById(Long id) {
		return this.calculosRepository.findById(id).get();
	}

}