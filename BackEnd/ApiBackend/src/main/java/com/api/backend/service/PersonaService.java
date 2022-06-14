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
        personaDTO.setExperiencias(persona.getExperiencias());
        personaDTO.setFormaciones(persona.getFormaciones());
        personaDTO.setProyectos(persona.getProyectos());
        personaDTO.setHabilidades(persona.getHabilidades());
        
        return personaDTO;
    }
    
    //Pasar DTO a entidad
    private Persona convertirDTOEntidad(PersonaDTO personaNuevaDTO){
        Persona personaNueva = new Persona();
        
        personaNueva.setId(personaNuevaDTO.getId());
        personaNueva.setEmail(personaNuevaDTO.getEmail());
        personaNueva.setApellido(personaNuevaDTO.getApellido());
        personaNueva.setNombre(personaNuevaDTO.getNombre());
        personaNueva.setPathFoto(personaNuevaDTO.getPathFoto());
        personaNueva.setTitulo(personaNuevaDTO.getTitulo());
        personaNueva.setUbicacion(personaNuevaDTO.getUbicacion());
        personaNueva.setSobreMi(personaNuevaDTO.getSobreMi());
        personaNueva.setExperiencias(personaNuevaDTO.getExperiencias());
        personaNueva.setFormaciones((personaNuevaDTO.getFormaciones()));
        personaNueva.setProyectos(personaNuevaDTO.getProyectos());
        personaNueva.setHabilidades(personaNuevaDTO.getHabilidades());
        
        return personaNueva;        
    }

    @Autowired
    private PersonaRepository personaRepo;

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaNuevaDTO) {
        Persona persona = convertirDTOEntidad(personaNuevaDTO);
        Persona personaNueva = personaRepo.save(persona);
        
        PersonaDTO personaRespuesta = convertirEntidadDTO(personaNueva);
        return personaRespuesta;
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
