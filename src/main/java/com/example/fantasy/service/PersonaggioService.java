package com.example.fantasy.service;

import java.util.List;
import com.example.fantasy.model.Personaggio;

public interface PersonaggioService {
	
	public List<Personaggio> getAllPersonaggio();
	public Personaggio getPersonaggioById(Long id);
	public void createPersonaggio(Personaggio personaggio);
	public void updatePersonaggioo(Long id, Personaggio personaggio);
	public void deletePersonaggio(Long id);
	public List<Personaggio> searchCharacter(String keyword);
	
}