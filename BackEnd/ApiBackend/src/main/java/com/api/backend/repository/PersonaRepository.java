package com.api.backend.repository;

import com.api.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** @author Norberto
 */

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
