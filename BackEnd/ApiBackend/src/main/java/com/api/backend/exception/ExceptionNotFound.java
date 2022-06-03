package com.api.backend.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Norberto
 */

@Getter @Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String nombreDelRecurso;
    private String nombreDelCampo;
    private long valorDelCampo;

    public ExceptionNotFound(String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(String.format("%s No encontrada con %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

}
