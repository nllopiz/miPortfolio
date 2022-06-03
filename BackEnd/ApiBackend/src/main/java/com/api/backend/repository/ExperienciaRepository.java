package com.api.backend.repository;

import com.api.backend.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{
    public List<Experiencia> findByPersonaId(Long id);
}
