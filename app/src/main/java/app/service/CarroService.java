package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepository;
	
	
	public String save (Carro carro) {
		this.carroRepository.save(carro);
		
		return "Carro Salvo com Sucesso!";
	}
	
	
	public String update (Carro carro, Long id) {
		carro.setId(id);
		
		this.carroRepository.save(carro);
	
		return "Carro Atualizado com Sucesso!";
	}
	
	
	public String delete (Long id) {
		this.carroRepository.deleteById(id);
		return "Carro Deletado com Sucesso!";
	}
	
	
	public List<Carro> findAll(){
		
		List<Carro> lista = this.carroRepository.findAll();
		return lista;
	}
	
	
	public Carro findById (Long id) {
		Optional<Carro> carro = this.carroRepository.findById(id);
		return carro.get();
	}
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}
		
	public List<Carro> findByMarca(Long idMarca){
		
		Marca marca = new Marca();
		marca.setId(idMarca);
		return this.carroRepository.findByMarca(marca);
	}
	
	public List<Carro> findAcimaAno(int ano){
		return this.carroRepository.findAcimaAno(ano);
	}
	
	
}
