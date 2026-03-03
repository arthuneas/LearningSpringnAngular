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
	

	public Saida calcular(Entrada entrada) {
		Saida saida = new Saida();
		
		List<Integer> lista = entrada.getLista();
		
		int soma = lista.stream().mapToInt(Integer::intValue).sum();
		int maior = lista.stream().max(Integer::compare).orElse(0);
		
		// Guarda os valores calculados no objeto que será retornado
		saida.setSoma(soma);
		saida.setMaiorNumeroLista(maior);
		
		return this.calculosRepository.save(saida);
	}
	
	
	public List<Saida> findAll() {
		List<Saida> lista = calculosRepository.findAll();
		return lista;
	}
		
}