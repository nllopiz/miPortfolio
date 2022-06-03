package com.api.backend.service;

import com.api.backend.exception.ExceptionNotFound;
import com.api.backend.dto.ExperienciaDTO;
import com.api.backend.exception.ApiException;
import com.api.backend.model.Experiencia;
import com.api.backend.model.Persona;
import com.api.backend.repository.ExperienciaRepository;
import com.api.backend.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepo;

    @Autowired
    private PersonaRepository personaRepo;

    //Pasar entidad a DTO
    private ExperienciaDTO convertirEntidadDTO(Experiencia experiencia) {
        ExperienciaDTO experienciaDTO = new ExperienciaDTO();

        experienciaDTO.setId(experiencia.getId());
        experienciaDTO.setTitulo(experiencia.getTitulo());
        experienciaDTO.setPeriodo(experiencia.getPeriodo());
        experienciaDTO.setPathLogo(experiencia.getPathLogo());
        experienciaDTO.setDescripcion(experiencia.getDescripcion());

        return experienciaDTO;
    }

    //Pasar DTO a entidad
    private Experiencia convertirDTOEntidad(ExperienciaDTO experienciaNuevaDTO) {
        Experiencia experienciaNueva = new Experiencia();

        experienciaNueva.setId(experienciaNuevaDTO.getId());
        experienciaNueva.setTitulo(experienciaNuevaDTO.getTitulo());
        experienciaNueva.setPeriodo(experienciaNuevaDTO.getPeriodo());
        experienciaNueva.setPathLogo(experienciaNuevaDTO.getPathLogo());
        experienciaNueva.setDescripcion(experienciaNuevaDTO.getDescripcion());

        return experienciaNueva;
    }

    @Override
    public ExperienciaDTO crearExperiencia(ExperienciaDTO experienciaNuevaDTO, Long id) {
        Experiencia experiencia = convertirDTOEntidad(experienciaNuevaDTO);
        Persona persona = personaRepo.findById(id)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", id));
        experiencia.setPersona(persona);
        Experiencia nuevaExperiencia = experienciaRepo.save(experiencia);
        return convertirEntidadDTO(nuevaExperiencia);
    }

    @Override
    public List<ExperienciaDTO> verExperienciasPorIdPersona(Long id) {
        List<Experiencia> experiencias = experienciaRepo.findByPersonaId(id);
        return experiencias.stream().map(experiencia -> convertirEntidadDTO(experiencia)).collect(Collectors.toList());
    }

    @Override
    public ExperienciaDTO verExperienciaPorId(Long idPersona, Long idExperiencia) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Experiencia experiencia = experienciaRepo.findById(idExperiencia)
                .orElseThrow(() -> new ExceptionNotFound("Experiencia", "id", idExperiencia));
        if(!experiencia.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La experiencia no existe");
        }
        return convertirEntidadDTO(experiencia);
    }

    @Override
    public ExperienciaDTO editarExperiencia(ExperienciaDTO datosExperiencia, Long idPersona, Long idExperiencia) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Experiencia experiencia = experienciaRepo.findById(idExperiencia)
                .orElseThrow(() -> new ExceptionNotFound("Experiencia", "id", idExperiencia));
        if(!experiencia.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La experiencia no existe");
        }
        
        experiencia.setDescripcion(datosExperiencia.getDescripcion());
        experiencia.setPathLogo(datosExperiencia.getPathLogo());
        experiencia.setPeriodo(datosExperiencia.getPeriodo());
        experiencia.setTitulo(datosExperiencia.getTitulo());
        
        Experiencia experienciaEditada = experienciaRepo.save(experiencia);
        
        return convertirEntidadDTO(experienciaEditada);
    }

    @Override
    public void eliminarExperiencia(Long idPersona, Long idExperiencia) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Experiencia experiencia = experienciaRepo.findById(idExperiencia)
                .orElseThrow(() -> new ExceptionNotFound("Experiencia", "id", idExperiencia));
        if(!experiencia.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La experiencia no existe");
        }
        
        experienciaRepo.delete(experiencia);
    }

}