package com.projetoIntegrado.sped.school;

import java.util.Date;

public record SchoolResponseDTO(Long id, String name, Boolean urgentCall, int securityLevel, String latitude,String longitude, Boolean selected) {

    public SchoolResponseDTO(Schools school) {
        this(school.getId(),school.getName(), school.getUrgentCall(), school.getSecurityLevel(), school.getLatitude(),school.getLongitude(), school.getSelected());
    }
}
