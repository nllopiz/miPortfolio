package com.api.backend.service;

import com.api.backend.dto.FormacionDTO;
import com.api.backend.exception.ApiException;
import com.api.backend.exception.ExceptionNotFound;
import com.api.backend.model.Formacion;
import com.api.backend.model.Persona;
import com.api.backend.repository.FormacionRepository;
import com.api.backend.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public class FormacionService implements IFormacionService {
    
    @Autowired
    private FormacionRepository formacionRepo;
    
    @Autowired
    private PersonaRepository personaRepo;
    
    //Pasar entidad a DTO
    private FormacionDTO convertirEntidadDTO(Formacion formacion) {
        FormacionDTO formacionDTO = new FormacionDTO();

        formacionDTO.setId(formacion.getId());
        formacionDTO.setTitulo(formacion.getTitulo());
        formacionDTO.setPeriodo(formacion.getPeriodo());
        formacionDTO.setPathLogo(formacion.getPathLogo());
        formacionDTO.setDescripcion(formacion.getDescripcion());

        return formacionDTO;
    }

    //Pasar DTO a entidad
    private Formacion convertirDTOEntidad(FormacionDTO formacionNuevaDTO) {
        Formacion formacionNueva = new Formacion();

        formacionNueva.setId(formacionNuevaDTO.getId());
        formacionNueva.setTitulo(formacionNuevaDTO.getTitulo());
        formacionNueva.setPeriodo(formacionNuevaDTO.getPeriodo());
        formacionNueva.setPathLogo(formacionNuevaDTO.getPathLogo());
        formacionNueva.setDescripcion(formacionNuevaDTO.getDescripcion());

        return formacionNueva;
    }

    @Override
    public FormacionDTO crearFormacion(FormacionDTO formacionNuevaDTO, Long idPersona) {
        Formacion formacion = convertirDTOEntidad(formacionNuevaDTO);
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        formacion.setPersona(persona);
        Formacion nuevaFormacion = formacionRepo.save(formacion);
        return convertirEntidadDTO(nuevaFormacion);
    }

    @Override
    public List<FormacionDTO> verFormacionesPorIdPersona(Long id) {
        List<Formacion> formaciones = formacionRepo.findByPersonaId(id);
        return formaciones.stream().map(formacion -> convertirEntidadDTO(formacion)).collect(Collectors.toList());
    }

    @Override
    public FormacionDTO verFormacionPorId(Long idPersona, Long idFormacion) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Formacion formacion = formacionRepo.findById(idFormacion)
                .orElseThrow(() -> new ExceptionNotFound("Formacion", "id", idFormacion));
        if(!formacion.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La formacion no existe");
        }
        return convertirEntidadDTO(formacion);

    }

    @Override
    public FormacionDTO editarFormacion(FormacionDTO datosFormacion, Long idPersona, Long idFormacion) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Formacion formacion = formacionRepo.findById(idFormacion)
                .orElseThrow(() -> new ExceptionNotFound("Formacion", "id", idFormacion));
        if(!formacion.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La formacion no existe");
        }
        
        formacion.setDescripcion(datosFormacion.getDescripcion());
        formacion.setPathLogo(datosFormacion.getPathLogo());
        formacion.setPeriodo(datosFormacion.getPeriodo());
        formacion.setTitulo(datosFormacion.getTitulo());
        
        Formacion formacionEditada = formacionRepo.save(formacion);
        
        return convertirEntidadDTO(formacionEditada);

    }

    @Override
    public void eliminarFormacion(Long idPersona, Long idFormacion) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Formacion formacion = formacionRepo.findById(idFormacion)
                .orElseThrow(() -> new ExceptionNotFound("Formacion", "id", idFormacion));
        if(!formacion.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La formacion no existe");
        }
        
        formacionRepo.delete(formacion);
    }
    
}
