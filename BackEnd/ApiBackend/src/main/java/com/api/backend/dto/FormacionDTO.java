package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class FormacionDTO {
    private Long id;
    private String titulo;
    private String periodo;
    private String pathLogo;
    private String descripcion;

    public FormacionDTO() {
    }

    public FormacionDTO(Long id, String titulo, String periodo, String pathLogo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.periodo = periodo;
        this.pathLogo = pathLogo;
        this.descripcion = descripcion;
    }
    
}