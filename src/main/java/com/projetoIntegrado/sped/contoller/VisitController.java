package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.visit.VisitRepository;
import com.projetoIntegrado.sped.visit.VisitResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping
    public List<VisitResponseDTO> getAll() {
        List<VisitResponseDTO> ul = visitRepository.findAll().stream().map(VisitResponseDTO::new).toList();
        return ul;
    }
}
