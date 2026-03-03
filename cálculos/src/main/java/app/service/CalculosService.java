package app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;

@Service
public class CalculosService {

	public Resultado calcular(Entrada entrada) {
		Resultado resultado = new Resultado();
		int soma = 0;
		double media = 0.0;
		int maior = 0;
		int menor = 0;
		int quantidade = 0;
		
		List<Integer> lista = entrada.getLista();
		
		// Verifica se a lista existe e não está vazia para evitar erro de divisão por zero
		if (lista != null && !lista.isEmpty()) {
			
			for (Integer numero : lista) {
				soma += numero;
			}
			
			// O (double) força o Java a fazer uma divisão com casas decimais
			media = (double) soma / lista.size(); 
			
			maior = Collections.max(lista);
			
			menor = Collections.min(lista);
			
			quantidade = lista.size();
			
			
		}
		
		// Guarda os valores calculados no objeto que será retornado
		resultado.setSoma(soma);
		resultado.setMedia(media);
		resultado.setMaior(maior);
		resultado.setMenor(menor);
		resultado.setQuantidade(quantidade);
		
		return resultado;
	}
}