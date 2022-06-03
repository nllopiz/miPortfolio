package com.api.backend.service;

import com.api.backend.dto.ProyectoDTO;
import java.util.List;

/** @author Norberto
 */

public interface IProyectoService {
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoNuevoDTO, Long idPersona);
    public List<ProyectoDTO> verProyectosPorIdPersona(Long idPersona);
    public ProyectoDTO verProyectoPorId(Long idPersona, Long idProyecto);
    public ProyectoDTO editarProyecto(ProyectoDTO datosProyectoDTO, Long idPersona, Long idProyecto);
    public void eliminarProyecto(Long idPersona, Long idProyecto);
}
