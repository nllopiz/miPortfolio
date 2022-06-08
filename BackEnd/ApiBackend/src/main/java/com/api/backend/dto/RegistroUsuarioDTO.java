package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class RegistroUsuarioDTO {
    private String email;
    private String password;

    public RegistroUsuarioDTO() {
    }

    public RegistroUsuarioDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    
}

