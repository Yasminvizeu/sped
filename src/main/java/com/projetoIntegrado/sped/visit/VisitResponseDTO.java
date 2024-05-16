package com.projetoIntegrado.sped.visit;

import java.util.Date;

public record VisitResponseDTO(Long id, Date visitDate, String visitPeriod) {

    public VisitResponseDTO(Visits visit) {
        this(visit.getId(), visit.getVisitDate(), visit.getVisitPeriod());
    }
}
