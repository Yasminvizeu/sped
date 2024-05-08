package com.projetoIntegrado.sped.school;

import java.util.Date;

public record SchoolResponseDTO(Long id, String name, Boolean urgentCall, int securityLevel, String location, Boolean selected) {

    public SchoolResponseDTO(Schools school) {
        this(school.getId(),school.getName(), school.getUrgentCall(), school.getSecurityLevel(), school.getLocation(), school.getSelected());

    }
}
