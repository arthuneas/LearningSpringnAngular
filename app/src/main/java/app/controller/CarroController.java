package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	
	//POST http://localhost:8080/api/carro/save
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		try {
			String mensagem = this.carroService.save(carro);
			return ResponseEntity.ok(mensagem);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao Consultar. Requisição: " + e.getMessage());
			
		}
		
	}
	
	
	//update http://localhost:8080/api/carro/update/1
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@RequestBody Carro carro, @PathVariable Long id) {
		try {
			String mensagem = this.carroService.update(carro, id);
			return ResponseEntity.ok(mensagem);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao Atualizar. Requisição: " + e.getMessage());
			
		}
		
	}
	
	
	//DELETE http://localhost:8080/api/carro/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id) {
		try {
			String mensagem = this.carroService.delete(id);
			return ResponseEntity.ok(mensagem);

			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao Deletar. Requisição: " + e.getMessage());
			
		}
		
	}
	
	
	//GET http://localhost:8080/api/carro/findAll
	@GetMapping("/findall")
	public ResponseEntity<List<Carro>> findAll(){
		try {
			List<Carro> lista = this.carroService.findAll();
			return ResponseEntity.ok(lista);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	//GET http://localhost:8080/api/carro/findById/1
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Carro> findById (@PathVariable Long id) {
		try {
			Carro carro = this.carroService.findById(id);
			return ResponseEntity.ok(carro);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	//consulta por select do JPQL
	@GetMapping("/findbynome")
	public ResponseEntity<List<Carro>> findbyNome(@RequestParam String nome){
		try {
			List<Carro> lista = this.carroService.findByNome(nome);
			return ResponseEntity.ok(lista);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	@GetMapping("/findbymarca")
	public ResponseEntity<List<Carro>> findbyMarca(@RequestParam Long idMarca){
		try {
			List<Carro> lista = this.carroService.findByMarca(idMarca);
			return ResponseEntity.ok(lista);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	@GetMapping("/findacimaano")
	public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int ano){
		try {
			List<Carro> lista = this.carroService.findAcimaAno(ano);
			return ResponseEntity.ok(lista);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}

}
