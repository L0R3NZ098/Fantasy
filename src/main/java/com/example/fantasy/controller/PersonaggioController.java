package com.example.fantasy.controller;

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
import com.example.fantasy.model.Personaggio;
import com.example.fantasy.service.PersonaggioService;

@RestController
@RequestMapping("/personaggio")
public class PersonaggioController {

	@Autowired
	private PersonaggioService service;

	@GetMapping("/getall")
	public ResponseEntity<List<Personaggio>> getAll() {
		List<Personaggio> getAll = service.getAllPersonaggio();
		return ResponseEntity.ok().body(getAll);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Personaggio> getById(@PathVariable(value = "id") Long id) {
		Personaggio getById = service.getPersonaggioById(id);
		return ResponseEntity.ok().body(getById);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createPersonaggio(@RequestBody Personaggio personaggio) {
		service.createPersonaggio(personaggio);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePersonaggio(@PathVariable(value = "id") Long id,
			@RequestBody Personaggio personaggio) {
		service.updatePersonaggioo(id, personaggio);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersonaggio(@PathVariable(value = "id") Long id) {
		service.deletePersonaggio(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Personaggio>> searchPersonaggio(@RequestParam(value = "keyword") String keyword) {
		List<Personaggio> search = service.searchCharacter(keyword);
		return ResponseEntity.ok().body(search);
	}

}
