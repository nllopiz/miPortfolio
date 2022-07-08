package com.api.backend.service;

import com.api.backend.dto.HabilidadDTO;
import com.api.backend.exception.ApiException;
import com.api.backend.exception.ExceptionNotFound;
import com.api.backend.model.Habilidad;
import com.api.backend.model.Persona;
import com.api.backend.repository.HabilidadRepository;
import com.api.backend.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepo;

    @Autowired
    private PersonaRepository personaRepo;
    
        //Pasar entidad a DTO
    private HabilidadDTO convertirEntidadDTO(Habilidad habilidad) {
        HabilidadDTO habilidadDTO = new HabilidadDTO();

        habilidadDTO.setId(habilidad.getId());
        habilidadDTO.setNombre(habilidad.getNombre());
        habilidadDTO.setPorcentajeDominio(habilidad.getPorcentajeDominio());

        return habilidadDTO;
    }

    //Pasar DTO a entidad
    private Habilidad convertirDTOEntidad(HabilidadDTO habilidadNuevaDTO) {
        Habilidad habilidadNueva = new Habilidad();

        habilidadNueva.setId(habilidadNuevaDTO.getId());
        habilidadNueva.setNombre(habilidadNuevaDTO.getNombre());
        habilidadNueva.setPorcentajeDominio(habilidadNuevaDTO.getPorcentajeDominio());

        return habilidadNueva;
    }

    
    @Override
    public HabilidadDTO crearHabilidad(HabilidadDTO habilidadNuevaDTO, Long idPersona) {
        Habilidad habilidad = convertirDTOEntidad(habilidadNuevaDTO);
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        habilidad.setPersona(persona);
        Habilidad nuevaHabilidad = habilidadRepo.save(habilidad);
        return convertirEntidadDTO(nuevaHabilidad);
    }

    @Override
    public List<HabilidadDTO> verHabilidadesPorIdPersona(Long idPersona) {
        List<Habilidad> habilidades = habilidadRepo.findByPersonaId(idPersona);
        return habilidades.stream().map(habilidad -> convertirEntidadDTO(habilidad)).collect(Collectors.toList());

    }

    @Override
    public HabilidadDTO verHabilidadPorId(Long idPersona, Long idHabilidad) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Habilidad habilidad = habilidadRepo.findById(idHabilidad)
                .orElseThrow(() -> new ExceptionNotFound("Habilidad", "id", idHabilidad));
        if(!habilidad.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La habilidad no existe");
        }
        return convertirEntidadDTO(habilidad);
    }

    @Override
    public HabilidadDTO editarHabilidad(HabilidadDTO datosHabilidad, Long idPersona, Long idHabilidad) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Habilidad habilidad = habilidadRepo.findById(idHabilidad)
                .orElseThrow(() -> new ExceptionNotFound("Habilidad", "id", idHabilidad));
        if(!habilidad.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La habilidad no existe");
        }
        
        habilidad.setNombre(datosHabilidad.getNombre());
        habilidad.setPorcentajeDominio(datosHabilidad.getPorcentajeDominio());
        
        Habilidad habilidadEditada = habilidadRepo.save(habilidad);
        
        return convertirEntidadDTO(habilidadEditada);
    }

    @Override
    public void eliminarHabilidad(Long idPersona, Long idHabilidad) {
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new ExceptionNotFound("Persona", "id", idPersona));
        Habilidad habilidad = habilidadRepo.findById(idHabilidad)
                .orElseThrow(() -> new ExceptionNotFound("Habilidad", "id", idHabilidad));
        if(!habilidad.getPersona().getId().equals(persona.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "La habilidad no existe");
        }
        
        habilidadRepo.delete(habilidad);
    }
    
}
