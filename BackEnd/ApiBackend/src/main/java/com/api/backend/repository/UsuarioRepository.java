package com.api.backend.repository;

import com.api.backend.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Norberto
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByEmail(String email);
    
    public Boolean existsByEmail(String email);
    
    
}
