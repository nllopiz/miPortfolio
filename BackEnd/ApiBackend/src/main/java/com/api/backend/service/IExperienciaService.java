package com.api.backend.service;

import com.api.backend.dto.ExperienciaDTO;
import java.util.List;

/** @author Norberto
 */

public interface IExperienciaService {
    public ExperienciaDTO crearExperiencia(ExperienciaDTO ExperienciaNueva, Long idPersona);
    public List<ExperienciaDTO> verExperienciasPorIdPersona(Long idPersona);
    public ExperienciaDTO verExperienciaPorId(Long idPersona, Long idExperiencia);
    public ExperienciaDTO editarExperiencia(ExperienciaDTO datosExperiencia, Long idPersona, Long idExperiencia);
    public void eliminarExperiencia(Long idPersona, Long idExperiencia);
}
