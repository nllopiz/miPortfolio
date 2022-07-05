package com.api.backend.controller;

import com.api.backend.dto.ProyectoDTO;
import com.api.backend.service.ProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @PostMapping("/{id}/proyectos")
    public ResponseEntity<ProyectoDTO> crearProyecto(@PathVariable(value = "id") Long id, @RequestBody ProyectoDTO proyecto){
        return new ResponseEntity<>(proyectoService.crearProyecto(proyecto, id), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/proyectos")
    public List<ProyectoDTO> verProyectosPorIdPersona(@PathVariable(value = "id") Long id) {
        return proyectoService.verProyectosPorIdPersona(id);
    }
    
    @GetMapping("/{idPersona}/proyectos/{id}")
    public ResponseEntity<ProyectoDTO> verProyectoPorId(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idProyecto){
        ProyectoDTO proyectoDTO = proyectoService.verProyectoPorId(idPersona, idProyecto);
        return new ResponseEntity<>(proyectoDTO, HttpStatus.OK);
    }
    
    @PutMapping("/{idPersona}/proyectos/{id}")
    public ResponseEntity<ProyectoDTO> editarProyecto(
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idProyecto, 
            @RequestBody ProyectoDTO datosProyecto){
        ProyectoDTO proyectoEditada = datosProyecto;
        return new ResponseEntity<>(proyectoService.editarProyecto(proyectoEditada, idPersona, idProyecto), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPersona}/proyectos/{id}")
    public ResponseEntity<String> eliminarProyecto(            
            @PathVariable(value = "idPersona") Long idPersona, 
            @PathVariable(value = "id") Long idProyecto){
        proyectoService.eliminarProyecto(idPersona, idProyecto);
        return new ResponseEntity<>("Proyecto eliminado", HttpStatus.OK);
    }

}
