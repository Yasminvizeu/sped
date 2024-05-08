package com.projetoIntegrado.sped.school;

import java.util.Date;

public record SchoolRequestDTO(String name, Boolean urgentCall, int securityLevel, String location, Boolean selected) {

}
