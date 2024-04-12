package com.projetoIntegrado.sped.contoller;


import com.projetoIntegrado.sped.user.UserRequestDTO;
import com.projetoIntegrado.sped.user.Users;
import com.projetoIntegrado.sped.userRoles.UserRoles;
import com.projetoIntegrado.sped.userRoles.UserRolesRepository;
import com.projetoIntegrado.sped.userRoles.UserRolesRequestDTO;
import com.projetoIntegrado.sped.userRoles.UserRolesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userRoles")
public class UserRolesController {

    @Autowired
    private UserRolesRepository repository;

    @GetMapping
    public List<UserRolesResponseDTO> getAll(){
        List<UserRolesResponseDTO> url =repository.findAll().stream().map(UserRolesResponseDTO::new).toList();
        return url;
    }

    @PostMapping
    public void saveUserRole(@RequestBody UserRolesRequestDTO data){
        UserRoles userRoles = new UserRoles(data);
        repository.save(userRoles);
        return;

    }





}
