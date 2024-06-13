package com.example.fantasy.model;

import com.example.fantasy.enums.ClasseEnum;
import com.example.fantasy.enums.RazzaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Creo una classe Personaggio mappata come entità del database personaggio
@Entity
@Table(name = "personaggio")
public class Personaggio {
	
	//Creo la chiave primaria con valore auto-incrementale
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	//Creo il campo nome che non deve contenere valori null
	@Nonnull 
	private String nome;
	
	//Creo il campo razza che non deve contenere valori null ed enumera i valori come stringhe
	@Nonnull 
	@Enumerated(EnumType.STRING)
	private RazzaEnum razza;
	
	//Creo il campo classe che non deve contenere valori null ed enumera i valori come stringhe
	@Nonnull 
	@Enumerated(EnumType.STRING)
	private ClasseEnum classe;
	
	//Creo il campo livello che non deve contenere valori null
	@Nonnull 
	private Integer livello;
	
	//Creo il campo descrizione che non deve contenere valori null
	@Nonnull 
	private String descrizione;
	
	//Creo la relazione many to one tra la chiave esterna e la chiave primaria della classe User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@Nonnull
	@JsonBackReference
	private User user;

	public Personaggio(Long id, String nome, RazzaEnum razza, ClasseEnum classe, Integer livello, String descrizione,
			User user) {
		super();
		this.id = id;
		this.nome = nome;
		this.razza = razza;
		this.classe = classe;
		this.livello = livello;
		this.descrizione = descrizione;
		this.user = user;
	}

	public Personaggio() {
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

	public RazzaEnum getRazza() {
		return razza;
	}

	public void setRazza(RazzaEnum razza) {
		this.razza = razza;
	}

	public ClasseEnum getClasse() {
		return classe;
	}

	public void setClasse(ClasseEnum classe) {
		this.classe = classe;
	}

	public Integer getLivello() {
		return livello;
	}

	public void setLivello(Integer livello) {
		this.livello = livello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
