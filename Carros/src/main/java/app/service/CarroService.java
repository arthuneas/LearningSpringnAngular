package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	
	//metodo de save
	public String save(Carro carro) {
		
		this.carroRepository.save(carro);
		
		return "Carro Salvo com Sucesso!";
	}
	

	//metodo de find e criação
	public Carro findById(Long id) {
		
		Optional<Carro> carro = this.carroRepository.findById(id);
		
		return carro.get();
	}
	
	
	//metood de update
	public Carro updateById(Long id, Carro carroAtualizado) {
		
		Optional<Carro> carro = this.carroRepository.findById(id);
		
		if (carro.isPresent()) {
			
			Carro carroExistente = carro.get();
			
			carroExistente.setMarca(carroAtualizado.getMarca());
			carroExistente.setModelo(carroAtualizado.getModelo());
			carroExistente.setNome(carroAtualizado.getNome());
			carroExistente.setAnoFabricacao(carroAtualizado.getAnoFabricacao());
			
			return this.carroRepository.save(carroExistente);
			
		} else {
			
			throw new RuntimeException("Carro com ID: " + id + " Não Encontrado!");
			
		}
		
	}
	
	
	public void deleteById(Long id) {
		
		Optional<Carro> carro = this.carroRepository.findById(id);
		
		if (carro.isPresent()) {
			
			this.carroRepository.deleteById(id);
			
		} else {
			
			throw new RuntimeException("Carro com ID: " + id + " Não Encontrado!");
			
		}
		
	}
	


}
