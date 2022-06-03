package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
public class ProyectoDTO {
    private Long id;
    private String titulo;
    private String pathImagen;
    private String descripcion;
    private String link;
    private String github;

    public ProyectoDTO() {
    }

    public ProyectoDTO(Long id, String titulo, String pathImagen, String descripcion, String link, String github) {
        this.id = id;
        this.titulo = titulo;
        this.pathImagen = pathImagen;
        this.descripcion = descripcion;
        this.link = link;
        this.github = github;
    }

}