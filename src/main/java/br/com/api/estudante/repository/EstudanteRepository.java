package br.com.api.estudante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.estudante.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

	Optional<Estudante> findById(Long id);
	
}
