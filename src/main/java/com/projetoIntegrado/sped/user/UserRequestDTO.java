package com.projetoIntegrado.sped.user;

import jakarta.persistence.Column;

public record UserRequestDTO(String cpf, String pass, String role) {

}
