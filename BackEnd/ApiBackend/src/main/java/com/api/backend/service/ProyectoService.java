package com.api.backend.service;

import com.api.backend.dto.ProyectoDTO;
import com.api.backend.exception.ApiException;
import com.api.backend.exception.ExceptionNotFound;
import com.api.backend.model.Persona;
import com.api.backend.model.Proyecto;
import com.api.backend.repository.PersonaRepository;
import com.api.backend.repository.ProyectoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepo;
    
    @Autowired
    private PersonaRepository personaRepo;
    
    //Pasar entidad a DTO
    private ProyectoDTO convertirEntidadDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();

        proyectoDTO.setId(proyecto.getId());
        proyectoDTO.setTitulo(proyecto.getTitulo());
        proyectoDTO.setPathImagen(proyecto.getPathImagen());
        proyectoDTO.setDescripcion(proyecto.getDescripcion());
        proyectoDTO.setLink(proyecto.getLink());
        proyectoDTO.setGithub(proyecto.getGithub());

        return proyectoDTO;
    }

    //Pasar DTO a entidad
    private Proyecto convertirDTOEntidad(ProyectoDTO proyectoNuevoDTO) {
        Proyecto proyectoNuevo = new Proyecto();

        proyectoNuevo.setId(proyectoNuevoDTO.getId());
        proyectoNuevo.setTitulo(proyectoNuevoDTO.getTitulo());
        proyectoNuevo.setPathImagen(proyectoNuevoDTO.getPathImagen());
        proyectoNuevo.setDescripcion(proyectoNuevoDTO.getDescripcion());
        proyectoNuevo.setLink(proyectoNuevoDTO.getLink());
        proyectoNuevo.setGithub(proyectoNuevoDTO.getGithub());

        return proyectoNuevo;
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoNuevoDTO, Long idPersona) {
        Proyecto proyecto = convertirDTOEntidad(proyectoNuevoDTO);
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        proyecto.setPersona(persona);
        Proyecto nuevoProyecto = proyectoRepo.save(proyecto);
        return convertirEntidadDTO(nuevoProyecto);
    }

    @Override
    public List<ProyectoDTO> verProyectosPorIdPersona(Long idPersona) {
        List<Proyecto> proyectos = proyectoRepo.findByPersonaId(idPersona);
        return proyectos.stream().map(proyecto -> convertirEntidadDTO(proyecto)).collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO verProyectoPorId(Long idPersona, Long idProyecto) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Proyecto proyecto = proyectoRepo.findById(idProyecto)
                .orElseThrow(() -> new ExceptionNotFound("Proyecto", "id", idProyecto));
        if(!proyecto.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La proyecto no existe");
        }
        return convertirEntidadDTO(proyecto);
    }

    @Override
    public ProyectoDTO editarProyecto(ProyectoDTO datosProyecto, Long idPersona, Long idProyecto) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Proyecto proyecto = proyectoRepo.findById(idProyecto)
                .orElseThrow(() -> new ExceptionNotFound("Proyecto", "id", idProyecto));
        if(!proyecto.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La proyecto no existe");
        }
        
        proyecto.setTitulo(datosProyecto.getTitulo());
        proyecto.setPathImagen(datosProyecto.getPathImagen());
        proyecto.setDescripcion(datosProyecto.getDescripcion());
        proyecto.setLink(datosProyecto.getLink());
        proyecto.setGithub(datosProyecto.getGithub());
        
        Proyecto proyectoEditada = proyectoRepo.save(proyecto);
        
        return convertirEntidadDTO(proyectoEditada);
    }

    @Override
    public void eliminarProyecto(Long idPersona, Long idProyecto) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Proyecto proyecto = proyectoRepo.findById(idProyecto)
                .orElseThrow(() -> new ExceptionNotFound("Proyecto", "id", idProyecto));
        if(!proyecto.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La proyecto no existe");
        }
        
        proyectoRepo.delete(proyecto);
    }
    
}