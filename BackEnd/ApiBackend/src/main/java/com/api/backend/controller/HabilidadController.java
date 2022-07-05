package com.api.backend.controller;

import com.api.backend.dto.HabilidadDTO;
import com.api.backend.service.HabilidadService;
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
@RequestMapping("api/personas")
@CrossOrigin
public class HabilidadController {
    
    @Autowired
    private HabilidadService habilidadService;
    
    @PostMapping("/{id}/habilidades")
    public ResponseEntity<HabilidadDTO> crearHabilidad(@PathVariable(value = "id") Long id, @RequestBody HabilidadDTO habilidad){
        return new ResponseEntity<>(habilidadService.crearHabilidad(habilidad, id), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/habilidades")
    public List<HabilidadDTO> verHabilidadsPorIdPersona(@PathVariable(value = "id") Long id) {
        return habilidadService.verHabilidadesPorIdPersona(id);
    }
    
    @GetMapping("/{idPersona}/habilidades/{id}")
    public ResponseEntity<HabilidadDTO> verHabilidadPorId(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idHabilidad){
        HabilidadDTO habilidadDTO = habilidadService.verHabilidadPorId(idPersona, idHabilidad);
        return new ResponseEntity<>(habilidadDTO, HttpStatus.OK);
    }
    
    @PutMapping("/{idPersona}/habilidades/{id}")
    public ResponseEntity<HabilidadDTO> editarHabilidad(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idHabilidad, 
            @RequestBody HabilidadDTO datosHabilidad){
        HabilidadDTO habilidadEditada = datosHabilidad;
        return new ResponseEntity<>(habilidadService.editarHabilidad(habilidadEditada, idPersona, idHabilidad), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPersona}/habilidades/{id}")
    public ResponseEntity<String> eliminarHabilidad(            
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idHabilidad){
        habilidadService.eliminarHabilidad(idPersona, idHabilidad);
        return new ResponseEntity<>("Habilidad eliminada", HttpStatus.OK);
    }

}
