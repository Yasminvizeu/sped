package com.projetoIntegrado.sped.visit;

import java.util.Date;

public record VisitRequestDTO(Date visitDate, String visitPeriod) {
    //dada da visita é o dia de hoje
    //periodo da visita é manha, tarde ou noite

}
