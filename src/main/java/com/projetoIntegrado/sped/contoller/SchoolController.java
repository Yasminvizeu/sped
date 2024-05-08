package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.school.SchoolRepository;
import com.projetoIntegrado.sped.school.SchoolRequestDTO;
import com.projetoIntegrado.sped.school.SchoolResponseDTO;
import com.projetoIntegrado.sped.school.Schools;
import com.projetoIntegrado.sped.user.UserRepository;
import com.projetoIntegrado.sped.user.UserRequestDTO;
import com.projetoIntegrado.sped.user.UserResponseDTO;
import com.projetoIntegrado.sped.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class SchoolController {



    @Autowired
    private SchoolRepository repository;



    @GetMapping
    public List<SchoolResponseDTO> getAll(){
        List<SchoolResponseDTO> ul =repository.findAll().stream().map(SchoolResponseDTO::new).toList();
        return ul;
    }


    @PostMapping
    public void saveSchool(@RequestBody SchoolRequestDTO data){
        Schools school = new Schools();
        repository.save(school);

    }











}
