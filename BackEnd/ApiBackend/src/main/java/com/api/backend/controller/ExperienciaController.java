package com.api.backend.controller;

import com.api.backend.dto.ExperienciaDTO;
import com.api.backend.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/personas/")
@CrossOrigin
public class ExperienciaController {
    
    @Autowired
    private ExperienciaService experienciaService;
    
    @PostMapping("/{id}/experiencias")
    public ResponseEntity<ExperienciaDTO> crearExperiencia(@PathVariable(value = "id") Long id, @RequestBody ExperienciaDTO experiencia){
        return new ResponseEntity<>(experienciaService.crearExperiencia(experiencia, id), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/experiencias")
    public List<ExperienciaDTO> verExperienciasPorIdPersona(@PathVariable(value = "id") Long id) {
        return experienciaService.verExperienciasPorIdPersona(id);
    }
    
    @GetMapping("/{idPersona}/experiencias/{id}")
    public ResponseEntity<ExperienciaDTO> verExperienciaPorId(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idExperiencia){
        ExperienciaDTO experienciaDTO = experienciaService.verExperienciaPorId(idPersona, idExperiencia);
        return new ResponseEntity<>(experienciaDTO, HttpStatus.OK);
    }
    
    @PutMapping("/{idPersona}/experiencias/{id}")
    public ResponseEntity<ExperienciaDTO> editarExperiencia(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idExperiencia, 
            @RequestBody ExperienciaDTO datosExperiencia){
        ExperienciaDTO experienciaEditada = datosExperiencia;
        return new ResponseEntity<>(experienciaService.editarExperiencia(experienciaEditada, idPersona, idExperiencia), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPersona}/experiencias/{id}")
    public ResponseEntity<String> eliminarExperiencia(            
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idExperiencia){
        experienciaService.eliminarExperiencia(idPersona, idExperiencia);
        return new ResponseEntity<>("Experiencia eliminada", HttpStatus.OK);
    }
    
}
