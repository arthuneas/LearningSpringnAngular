package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	//metodo post
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro){
		
		try {
			
			String mensagem = this.carroService.save(carro);
			return ResponseEntity.ok(mensagem);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("Erro ao Salvar! requisição: " + e.getMessage());
			
		}
		
	}
	
	
	
	//metodo get
	//busca por id
	@GetMapping("/findById/{id}") //o {id} é o mesmo da pathvariable
	public ResponseEntity<Carro> findById(@PathVariable Long id){
		
		try {
			Carro carro = this.carroService.findById(id);
			return ResponseEntity.ok(carro);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	//fazendo update
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Carro> updateById(@PathVariable Long id, @RequestBody Carro carro){
		
		try {
			carro = this.carroService.updateById(id, carro);
			return ResponseEntity.ok(carro);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	//fazendo delete
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		try {
			this.carroService.deleteById(id);
			
			return ResponseEntity.ok("Carro com ID " + id + " deletado com sucesso!");
					
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("Erro ao Deletar! requisição: " + e.getMessage());
			
		}
		
	}
	
	
	

}
