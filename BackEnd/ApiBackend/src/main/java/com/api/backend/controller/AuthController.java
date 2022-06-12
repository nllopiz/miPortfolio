package com.api.backend.controller;

import com.api.backend.dto.LoginDTO;
import com.api.backend.dto.RegistroUsuarioDTO;
import com.api.backend.model.Rol;
import com.api.backend.model.Usuario;
import com.api.backend.repository.RolRepository;
import com.api.backend.repository.UsuarioRepository;
import com.api.backend.security.JwtAuthResponseDTO;
import com.api.backend.security.JwtTokenProvider;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Norberto
 */

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private RolRepository rolRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @PostMapping("/iniciarSesion")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        //obtner el token
        String token = jwtTokenProvider.generarToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    }
    
    @PostMapping("/registrarUsuario")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroUsuarioDTO registroUsuarioDTO) {
        if(usuarioRepo.existsByEmail(registroUsuarioDTO.getEmail())) {
            return new ResponseEntity<>("Ese mail ya existe", HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = new Usuario();
        usuario.setEmail(registroUsuarioDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroUsuarioDTO.getPassword()));
        
        Rol roles = rolRepo.findByNombre("ROLE_ADMIN").get();
        usuario.setRoles(Collections.singleton(roles));
        
        usuarioRepo.save(usuario);
        return new ResponseEntity<>("Usuario registrado", HttpStatus.OK);
    }
}
