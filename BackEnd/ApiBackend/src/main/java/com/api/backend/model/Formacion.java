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
@Table(name = "formaciones")
        
public class Formacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "periodo", nullable = false)
    private String periodo;
    @Column(name = "pathlogo", nullable = true)
    private String pathLogo;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;
    
    public Formacion(){
    
    }

    public Formacion(Long id, String titulo, String periodo, String pathLogo, String descripcion, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.periodo = periodo;
        this.pathLogo = pathLogo;
        this.descripcion = descripcion;
        this.persona = persona;
    }    
    
}
