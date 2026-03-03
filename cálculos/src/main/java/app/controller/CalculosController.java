package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Entrada;
import app.entity.Saida;
import app.service.CalculosService;

@RestController
@RequestMapping("/api/calculos")
public class CalculosController {
	
	@Autowired //evita allocação de memoria excedente
	private CalculosService calculosService;
	
	
	@PostMapping
	public ResponseEntity<Saida> calcular(@RequestBody Entrada entrada){ //entrada é uma lista do tipo Entrada
		
		try {
			
			Saida resultado = this.calculosService.calcular(entrada);
			
			return ResponseEntity.status(201).body(resultado); //mandamos os status e o resultado da requisiçao			
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();				
			
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Saida>> findAll(){ //entrada é uma lista do tipo Entrada
		
		try {
			
			List<Saida> lista = this.calculosService.findAll();		
			return ResponseEntity.ok(lista); //mandamos os status e o resultado da requisiçao
			
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
					
		}
		
	}
	
	
}
