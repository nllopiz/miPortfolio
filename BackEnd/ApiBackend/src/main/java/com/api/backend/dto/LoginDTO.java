package com.api.backend.dto;

import lombok.Getter;
import lombok.Setter;

/** @author Norberto
 */

@Setter @Getter
public class LoginDTO {
    private String email;
    private String password;
}
