package com.api.backend.repository;

import com.api.backend.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */

public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    public List<Proyecto> findByPersonaId(Long id);
}
