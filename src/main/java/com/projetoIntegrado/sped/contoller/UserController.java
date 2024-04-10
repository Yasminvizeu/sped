package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.user.UserRepository;
import com.projetoIntegrado.sped.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<Users> getAll(){
        List<Users> ul = repository.findAll();
        return ul;
    }



}
