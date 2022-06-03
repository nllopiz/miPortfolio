package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class HabilidadDTO {
    Long id;
    String nombre;
    String porcentajes;

    public HabilidadDTO() {
    }

    public HabilidadDTO(Long id, String nombre, String porcentajes) {
        this.id = id;
        this.nombre = nombre;
        this.porcentajes = porcentajes;
    }    

}
