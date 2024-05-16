package com.projetoIntegrado.sped.visit.school;

import java.util.Date;

public record VisitResponseDTO(Long id,
                               Long schoolId,
                               Long userId,
                               Date visitDate,
                               String visitPeriod) {

    public VisitResponseDTO(Visits visit) {
        this(visit.getId(),visit.getSchool().getId(), visit.getUser().getId(), visit.getVisitDate(), visit.getVisitPeriod());
    }
}
