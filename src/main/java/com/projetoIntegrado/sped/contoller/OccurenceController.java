package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.occurence.OccurenceRepository;
import com.projetoIntegrado.sped.occurence.OccurenceRequestDTO;
import com.projetoIntegrado.sped.occurence.Occurences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/occurence")
public class OccurenceController {

    @Autowired
    private OccurenceRepository occurenceRepository;

    @PostMapping
    public void saveOccurence(@RequestBody OccurenceRequestDTO data){
        Occurences occurence = new Occurences(data);
        occurenceRepository.save(occurence);
    }
}
