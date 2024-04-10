package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.user.UserRepository;
import com.projetoIntegrado.sped.user.Users;
import com.projetoIntegrado.sped.user.UsersResposesDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<UsersResposesDTO> getAll(){
        List<Users> ul = repository.findAll().stream().map(UsersResposesDTO::new);
        return ul;
    }



}
