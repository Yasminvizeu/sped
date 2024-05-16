package com.projetoIntegrado.sped.visit.school;

import java.util.Date;

public record VisitRequestDTO(Long schoolId,
                              Long userId,
                              Date visitDate,
                              String visitPeriod) {
    //dada da visita é o dia de hoje
    //periodo da visita é manha, tarde ou noite

}
