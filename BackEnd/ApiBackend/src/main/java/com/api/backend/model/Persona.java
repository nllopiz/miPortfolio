package com.api.backend.model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Getter @Setter
@Entity
@Table(name="personas", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "pathFoto", nullable = true)
    private String pathFoto;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;
    @Column(name = "sobreMi", nullable = false)
    private String sobreMi;

    //@JsonBackReference //para soluciona errores de serialización
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experiencia> experiencias = new HashSet<>();

    //@JsonBackReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Formacion> formaciones = new HashSet<>();
    
    //@JsonBackReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Proyecto> proyectos = new HashSet<>();

    //@JsonBackReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Habilidad> habilidades = new HashSet<>();
    
    public Persona(){
        
    }

    public Persona(Long id, String email, String apellido, String nombre, String pathFoto, String titulo, String ubicacion, String sobreMi) {
        this.id = id;
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
        this.pathFoto = pathFoto;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.sobreMi = sobreMi;
    }

    
}