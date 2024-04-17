package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.user.AuthenticationDTO;
import com.projetoIntegrado.sped.user.RegisterDTO;
import com.projetoIntegrado.sped.user.UserRepository;
import com.projetoIntegrado.sped.user.Users;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

//    @Autowired
//    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.cpf(), data.pass());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
//        if(this.repository.findByCpf(data.cpf()) != null) return ResponseEntity.badRequest().build();
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.pass());
//        Users newUser = new Users(data.cpf(), encryptedPassword, data.role());
//
//        this.repository.save(newUser);
//
//        return ResponseEntity.ok().build();
//    }

}
