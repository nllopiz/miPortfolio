package com.api.backend.service;

import com.api.backend.dto.PersonaDTO;
import java.util.List;
import org.springframework.stereotype.Service;

/** @author Norberto
 */

@Service
public interface IPersonaService {
    public PersonaDTO crearPersona(PersonaDTO personaNuevaDTO);
    public List<PersonaDTO> verPersonas();
    public PersonaDTO buscarPersonaPorId(Long id);
    public PersonaDTO editarPersona(Long id, PersonaDTO personaEditadaDTO);
    public void eliminarPersona(Long id);
    

}
