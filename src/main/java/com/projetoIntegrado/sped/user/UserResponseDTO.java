package com.projetoIntegrado.sped.user;

public record UserResponseDTO(Long id, String cpf, String pass,String role, String name, String city, String phone) {

    public UserResponseDTO(Users users){
        this(users.getId() ,users.getCpf(), users.getPass(), users.getRole() ,users.getName(), users.getCity(), users.getPhone());
    }

}
