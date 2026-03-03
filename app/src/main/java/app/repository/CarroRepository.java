package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;
import app.entity.Marca;

public interface CarroRepository extends JpaRepository <Carro, Long>{
	
	//selects, filtros do JPQL
	
	public List<Carro> findByNome(String nome);
	
	public List<Carro> findByMarca(Marca marca);
	
	@Query("from Carro c where c .ano > :ano") //os dois ponto se refere ao parametro do metodo, com valores identicos
	public List<Carro> findAcimaAno(int ano);
	
	

}
