package com.api.backend.controller;

import com.api.backend.dto.FormacionDTO;
import com.api.backend.service.FormacionService;
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
public class FormacionController {
    
    @Autowired
    private FormacionService formacionService;
    
    @PostMapping("/{id}/formaciones")
    public ResponseEntity<FormacionDTO> crearFormacion(@PathVariable(value = "id") Long id, @RequestBody FormacionDTO formacion){
        return new ResponseEntity<>(formacionService.crearFormacion(formacion, id), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/formaciones")
    public List<FormacionDTO> verFormacionsPorIdPersona(@PathVariable(value = "id") Long id) {
        return formacionService.verFormacionesPorIdPersona(id);
    }
    
    @GetMapping("/{idPersona}/formaciones/{id}")
    public ResponseEntity<FormacionDTO> verFormacionPorId(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idFormacion){
        FormacionDTO formacionDTO = formacionService.verFormacionPorId(idPersona, idFormacion);
        return new ResponseEntity<>(formacionDTO, HttpStatus.OK);
    }
    
    @PutMapping("/{idPersona}/formaciones/{id}")
    public ResponseEntity<FormacionDTO> editarFormacion(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idFormacion, 
            @RequestBody FormacionDTO datosFormacion){
        FormacionDTO formacionEditada = datosFormacion;
        return new ResponseEntity<>(formacionService.editarFormacion(formacionEditada, idPersona, idFormacion), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPersona}/formaciones/{id}")
    public ResponseEntity<String> eliminarFormacion(            
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idFormacion){
        formacionService.eliminarFormacion(idPersona, idFormacion);
        return new ResponseEntity<>("Formacion eliminada", HttpStatus.OK);
    }

}
