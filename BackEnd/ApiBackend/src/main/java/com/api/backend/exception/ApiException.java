package com.api.backend.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/** @author Norberto
 */

@Getter @Setter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private HttpStatus estado;
    private String mensaje;

    public ApiException(HttpStatus estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }
    
    public ApiException(HttpStatus estado, String mensaje, String mensaje1) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.mensaje = mensaje;
    }
    
    
}
