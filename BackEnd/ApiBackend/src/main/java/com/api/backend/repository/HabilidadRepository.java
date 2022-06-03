package com.api.backend.repository;

import com.api.backend.model.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */

public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
    public List<Habilidad> findByPersonaId(Long id);
}
