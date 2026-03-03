package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int ano;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Marca marca; //há muitos carros de uma unica marca
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "carro_proprietario", 
		joinColumns = @JoinColumn(name = "carro_id"), 
		inverseJoinColumns = @JoinColumn(name = "proprietario_id") 
	)
	private List<Proprietario> proprietarios; //uma lista de que varios carros tem varios proprietarios
	

	
}
