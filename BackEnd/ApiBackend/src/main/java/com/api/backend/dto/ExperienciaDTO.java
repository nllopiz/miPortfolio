package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class ExperienciaDTO {
    private Long id;
    private String titulo;
    private String periodo;
    private String pathLogo;
    private String descripcion;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(Long idExperiencia, String titulo, String periodo, String pathLogo, String descripcion) {
        this.id = idExperiencia;
        this.titulo = titulo;
        this.periodo = periodo;
        this.pathLogo = pathLogo;
        this.descripcion = descripcion;
    }

}