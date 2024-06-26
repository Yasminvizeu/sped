package com.projetoIntegrado.sped.occurence;

import com.projetoIntegrado.sped.school.Schools;

public record OccurenceResponseDTO(Long id, String code, String user_Name, String schoolName, String visitPeriod, String description) {

    public OccurenceResponseDTO(Occurences occurences) {
        this(occurences.getId(), occurences.getCode(), occurences.getUser_Name(), occurences.getSchoolName(), occurences.getVisitPeriod(), occurences.getDescription());
    }
}
