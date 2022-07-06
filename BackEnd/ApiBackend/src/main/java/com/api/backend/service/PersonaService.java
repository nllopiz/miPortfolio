package com.api.backend.service;

import com.api.backend.exception.ExceptionNotFound;
import com.api.backend.dto.PersonaDTO;
import com.api.backend.model.Persona;
import com.api.backend.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public class PersonaService implements IPersonaService {
    
    //Pasar entidad a DTO
    private PersonaDTO convertirEntidadDTO(Persona persona){
        PersonaDTO personaDTO = new PersonaDTO();
        
        personaDTO.setId(persona.getId());
        personaDTO.setEmail(persona.getEmail());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setPathFoto(persona.getPathFoto());
        personaDTO.setTitulo(persona.getTitulo());
        personaDTO.setUbicacion(persona.getUbicacion());
        personaDTO.setSobreMi(persona.getSobreMi());
/*        personaDTO.setExperiencias(persona.getExperiencias());
        personaDTO.setFormaciones(persona.getFormaciones());
        personaDTO.setProyectos(persona.getProyectos());
        personaDTO.setHabilidades(persona.getHabilidades());
*/        
        return personaDTO;
    }
    
    //Pasar DTO a entidad
    private Persona convertirDTOEntidad(PersonaDTO personaDTO){
        Persona personaNueva = new Persona();
        
        personaNueva.setId(personaDTO.getId());
        personaNueva.setEmail(personaDTO.getEmail());
        personaNueva.setApellido(personaDTO.getApellido());
        personaNueva.setNombre(personaDTO.getNombre());
        personaNueva.setPathFoto(personaDTO.getPathFoto());
        personaNueva.setTitulo(personaDTO.getTitulo());
        personaNueva.setUbicacion(personaDTO.getUbicacion());
        personaNueva.setSobreMi(personaDTO.getSobreMi());
/*        personaNueva.setExperiencias(personaDTO.getExperiencias());
        personaNueva.setFormaciones((personaDTO.getFormaciones()));
        personaNueva.setProyectos(personaDTO.getProyectos());
        personaNueva.setHabilidades(personaDTO.getHabilidades());
*/        
        return personaNueva;        
    }

    @Autowired
    private PersonaRepository personaRepo;

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        Persona persona = convertirDTOEntidad(personaDTO);
        Persona personaNueva = personaRepo.save(persona);
        
        PersonaDTO personaRespuesta = convertirEntidadDTO(personaNueva);
        return personaRespuesta;
    }
    
    @Override
    public PersonaDTO editarPersona(Long id, PersonaDTO personaEditadaDTO) {
        Persona personaEditar = personaRepo.findById(id)
                .orElseThrow(()-> new ExceptionNotFound("Persona", "id", id));
        personaEditar.setApellido(personaEditadaDTO.getApellido());
        personaEditar.setEmail(personaEditadaDTO.getEmail());
        personaEditar.setNombre(personaEditadaDTO.getNombre());
        personaEditar.setPathFoto(personaEditadaDTO.getPathFoto());
        personaEditar.setSobreMi(personaEditadaDTO.getSobreMi());
        personaEditar.setTitulo(personaEditadaDTO.getTitulo());
        personaEditar.setUbicacion(personaEditadaDTO.getUbicacion());
        
        Persona personaEditada = personaRepo.save(personaEditar);
        return convertirEntidadDTO(personaEditada);
        
    }

    @Override
    public List<PersonaDTO> verPersonas() {
        List<Persona> personas = personaRepo.findAll();
        return personas.stream().map(persona -> convertirEntidadDTO(persona)).collect(Collectors.toList());
    }

    @Override
    public PersonaDTO buscarPersonaPorId(Long id) {
        Persona persona = personaRepo.findById(id)
                .orElseThrow(()-> new ExceptionNotFound("Persona", "id", id));
        return convertirEntidadDTO(persona);
    }


    @Override
    public void eliminarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    

}
