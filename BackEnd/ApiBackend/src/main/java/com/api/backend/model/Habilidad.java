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
@Table(name = "habilidades")
public class Habilidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "porcentajeDominio", nullable = false)
    int porcentajeDominio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;

    public Habilidad() {
    
    }

    public Habilidad(Long id, String nombre, int porcentajeDominio, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.porcentajeDominio = porcentajeDominio;
        this.persona = persona;
    }
    
    
}
