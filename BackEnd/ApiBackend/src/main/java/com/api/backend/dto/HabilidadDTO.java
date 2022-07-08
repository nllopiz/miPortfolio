package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class HabilidadDTO {
    Long id;
    String nombre;
    int porcentajeDominio;

    public HabilidadDTO() {
    }

    public HabilidadDTO(Long id, String nombre, int porcentajeDominio) {
        this.id = id;
        this.nombre = nombre;
        this.porcentajeDominio = porcentajeDominio;
    }  

}
