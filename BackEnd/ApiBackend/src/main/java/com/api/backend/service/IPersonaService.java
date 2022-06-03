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
    //El método editarPersona(PersonaDTO datosNuevosPersona, Long id) se implementa
    //en el controlador, combinando buscarPersonaPorId() y crearPersona()
    public void eliminarPersona(Long id);
    

}
