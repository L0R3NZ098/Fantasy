package com.example.fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.fantasy.model.Personaggio;

@Repository
public interface PersonaggioRepository extends JpaRepository<Personaggio, Long> {

	@Query(value = "SELECT * FROM personaggio p WHERE p.nome=?1 OR p.classe=?1 OR p.razza=?1", nativeQuery = true)
	public List<Personaggio> findPersonaggio(String keyword);

}
