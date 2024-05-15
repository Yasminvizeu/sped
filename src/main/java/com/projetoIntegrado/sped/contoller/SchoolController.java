package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.school.SchoolRepository;
import com.projetoIntegrado.sped.school.SchoolRequestDTO;
import com.projetoIntegrado.sped.school.SchoolResponseDTO;
import com.projetoIntegrado.sped.school.Schools;
import com.projetoIntegrado.sped.user.UserRepository;
import com.projetoIntegrado.sped.user.UserRequestDTO;
import com.projetoIntegrado.sped.user.UserResponseDTO;
import com.projetoIntegrado.sped.user.Users;
import com.projetoIntegrado.sped.visit.school.VisitRepository;
import com.projetoIntegrado.sped.visit.school.VisitRequestDTO;
import com.projetoIntegrado.sped.visit.school.VisitResponseDTO;
import com.projetoIntegrado.sped.visit.school.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping
    public List<SchoolResponseDTO> getAll(){
        List<SchoolResponseDTO> ul = schoolRepository.findAll().stream().map(SchoolResponseDTO::new).toList();
        return ul;
    }

    @PostMapping
    public void saveSchool(@RequestBody SchoolRequestDTO data){
        Schools school = new Schools();
        schoolRepository.save(school);
    }

    @PostMapping("/visit/{id}")
    public void modalSaveVisit(@RequestBody VisitRequestDTO visitData){
        Visits visit = new Visits();
        visitRepository.save(visit);
        //schoolRepository.selectSchools(visitData.schoolId());
    }

}
