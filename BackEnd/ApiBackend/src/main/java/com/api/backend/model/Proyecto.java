package com.api.backend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
@Entity
@Table(name = "proyectos")

public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "pathImagen", nullable = true)
    private String pathImagen;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "github", nullable = true)
    private String github;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public Proyecto() {
    }

    public Proyecto(Long id, String titulo, String pathImagen, String descripcion, String link, String github, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.pathImagen = pathImagen;
        this.descripcion = descripcion;
        this.link = link;
        this.github = github;
        this.persona = persona;
    }

}