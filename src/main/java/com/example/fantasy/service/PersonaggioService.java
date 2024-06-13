package com.example.fantasy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.fantasy.model.Personaggio;

@Service
public interface PersonaggioService {
	
	public List<Personaggio> getAllPersonaggio();
	public Personaggio getPersonaggioById(Long id);
	public void createPersonaggio(Personaggio personaggio);
	public void updatePersonaggioo(Long id, Personaggio personaggio);
	public void deletePersonaggio(Long id);
	public List<Personaggio> searchCharacter(String keyword);
	
}
