package com.projetoIntegrado.sped.user;

import jakarta.persistence.Column;

public record UserRequestDTO(int addressNumber, String city, String neighbourhood, int postalCode, String state, String street, int cpf, String pass ) {


}
