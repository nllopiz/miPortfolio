package com.api.backend.service;

import com.api.backend.dto.FormacionDTO;
import java.util.List;

/**
 *
 * @author Norberto
 */
public interface IFormacionService {
    public FormacionDTO crearFormacion(FormacionDTO formacionNuevaDTO, Long idPersona);
    public List<FormacionDTO> verFormacionesPorIdPersona(Long idPersona);
    public FormacionDTO verFormacionPorId(Long idPersona, Long idFormacion);
    public FormacionDTO editarFormacion(FormacionDTO datosFormacionDTO, Long idPersona, Long idFormacion);
    public void eliminarFormacion(Long idPersona, Long idFormacion);
}
