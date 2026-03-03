package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Entrada;
import app.entity.Resultado;
import app.service.CalculosService;

@RestController
@RequestMapping("/calculos")
public class CalculosController {
	
	@Autowired //evita allocação de memoria excedente
	private CalculosService calculosService;
	
	
	@GetMapping("")
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada){ //entrada é uma lista do tipo Entrada
		
		try {
			
			Resultado resultado = this.calculosService.calcular(entrada);
			
			return ResponseEntity.ok(resultado); //mandamos os status e o resultado da requisiçao
			
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
					
			
		}
		
	}
	
}
