package com.projetoIntegrado.sped.user;

public record UserResponseDTO(Long id, String cpf, String pass) {

    public UserResponseDTO(Users users){
        this(users.getId() ,users.getCpf(), users.getPass());
    }

}
