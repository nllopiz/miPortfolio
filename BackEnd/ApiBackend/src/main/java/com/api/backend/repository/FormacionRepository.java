package com.api.backend.repository;

import com.api.backend.model.Formacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */

public interface FormacionRepository extends JpaRepository<Formacion, Long> {
    public List<Formacion> findByPersonaId(Long id);
}
