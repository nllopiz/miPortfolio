package com.api.backend.service;

import com.api.backend.dto.HabilidadDTO;
import java.util.List;

/** @author Norberto
 */

public interface IHabilidadService {
    public HabilidadDTO crearHabilidad(HabilidadDTO HabilidadNueva, Long idPersona);
    public List<HabilidadDTO> verHabilidadesPorIdPersona(Long idPersona);
    public HabilidadDTO verHabilidadPorId(Long idPersona, Long idHabilidad);
    public HabilidadDTO editarHabilidad(HabilidadDTO datosHabilidad, Long idPersona, Long idHabilidad);
    public void eliminarHabilidad(Long idPersona, Long idHabilidad);
}

