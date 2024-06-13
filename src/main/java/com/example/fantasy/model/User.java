package com.example.fantasy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//Creo una classe User mappata come entità del database user
@Entity
@Table(name = "user")
public class User {
	
	//Creo la chiave primaria con valore auto-incrementale
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	//Creo il campo nome che non deve contenere valori null
	@Nonnull
	private String nome;
	
	//Creo la relazione one to many tra la chiave primaria e la chiave esterna della classe Personaggio
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Personaggio> personaggi;

	public User(Long id, String nome, List<Personaggio> personaggi) {
		super();
		this.id = id;
		this.nome = nome;
		this.personaggi = personaggi;
	}

	public User() {
		super(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}

	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}

}
