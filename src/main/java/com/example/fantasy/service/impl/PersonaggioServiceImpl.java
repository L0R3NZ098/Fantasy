package com.example.fantasy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fantasy.exception.ResourceNotFoundException;
import com.example.fantasy.model.Personaggio;
import com.example.fantasy.repository.PersonaggioRepository;
import com.example.fantasy.service.PersonaggioService;

@Service
public class PersonaggioServiceImpl implements PersonaggioService {

	@Autowired
	private PersonaggioRepository repo;

	@Override
	public List<Personaggio> getAllPersonaggio() {
		List<Personaggio> getAll = repo.findAll();
		return getAll;
	}

	@Override
	public Personaggio getPersonaggioById(Long id) {
		Optional<Personaggio> getById = repo.findById(id);
		if (getById.isPresent()) {
			return getById.get();
		} else {
			throw new ResourceNotFoundException("Personaggio", "id", id);
		}

	}

	@Override
	public void createPersonaggio(Personaggio personaggio) {
		repo.save(personaggio);
	}

	@Override
	public void updatePersonaggioo(Long id, Personaggio personaggio) {
		Personaggio update = this.getPersonaggioById(id);
		update.setNome(personaggio.getNome());
		update.setRazza(personaggio.getRazza());
		update.setClasse(personaggio.getClasse());
		update.setLivello(personaggio.getLivello());
		update.setDescrizione(personaggio.getDescrizione());
		repo.save(update);
	}

	@Override
	public void deletePersonaggio(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Personaggio> searchCharacter(String keyword) {
		List<Personaggio> find = repo.findPersonaggio(keyword);
		return find;
	}

}
