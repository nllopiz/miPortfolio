package com.api.backend.repository;

import com.api.backend.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */


public interface RolRepository extends JpaRepository <Rol, Long>{
    public Optional<Rol> findByNombre(String nombre);
}
