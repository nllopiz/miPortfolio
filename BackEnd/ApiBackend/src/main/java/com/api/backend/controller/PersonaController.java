package com.api.backend.controller;

import com.api.backend.dto.PersonaDTO;
import com.api.backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Norberto
 */

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;    
    
    
    @PostMapping
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO personaNuevaDTO){
        return new ResponseEntity<>(personaService.crearPersona(personaNuevaDTO), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<PersonaDTO> verPersonas(){
        return personaService.verPersonas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> verPersonaPorId(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(personaService.buscarPersonaPorId(id));
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> editarPersona(@RequestBody PersonaDTO datosNuevosPersonaDTO, @PathVariable(name = "id") long id){
        //PersonaDTO personaRespuesta = personaService.editarPersona(personaDTO, id);
        PersonaDTO personaBuscada = personaService.buscarPersonaPorId(id);
        personaBuscada = datosNuevosPersonaDTO;
        return new ResponseEntity<>(personaService.crearPersona(personaBuscada), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable(name = "id") long id){
        personaService.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada", HttpStatus.OK);
        
    }
}
