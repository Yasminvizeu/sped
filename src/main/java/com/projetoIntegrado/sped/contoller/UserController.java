package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.user.UserRepository;

import com.projetoIntegrado.sped.user.UserRequestDTO;
import com.projetoIntegrado.sped.user.UserResponseDTO;
import com.projetoIntegrado.sped.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserRepository repository;



    @GetMapping
    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> ul =repository.findAll().stream().map(UserResponseDTO::new).toList();
        return ul;
    }


    @PostMapping
    public void saveUser(@RequestBody UserRequestDTO data){
        Users user = new Users(data);
        repository.save(user);

    }

    @GetMapping("/encontraCpf/{cpf}")
    public Users encontraCpf(@PathVariable int cpf) {
        return repository.findIdByCpf(cpf);
    }

    @GetMapping("/gcm")
    public void redirecionaGcm(@PathVariable int cpf) {

    }











}
