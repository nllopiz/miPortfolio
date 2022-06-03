package com.api.backend.dto;

/*import com.backend.api.model.Experiencia;
import com.backend.api.model.Formacion;
import java.util.Set;*/
import lombok.Getter;
import lombok.Setter;

/**
 * @author Norberto
 */
@Getter
@Setter
public class PersonaDTO {

    private Long id;
    private String email;
    private String apellido;
    private String nombre;
    private String pathFoto;
    private String titulo;
    private String ubicacion;
    private String sobreMi;
/*    private Set<Experiencia> experiencias;
    private Set<Formacion> formaciones;
  */  

    public PersonaDTO() {
    }

    public PersonaDTO(Long id, String email, String apellido, String nombre, String pathFoto, String titulo, String ubicacion, String sobreMi) {
        this.id = id;
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
        this.pathFoto = pathFoto;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.sobreMi = sobreMi;
/*        this.experiencias = experiencias;
        this.formaciones = formaciones;
*/
    }

    
}
