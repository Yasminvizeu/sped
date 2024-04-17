package com.projetoIntegrado.sped.user;

public record UserResponseDTO(Long id,int addressNumber, String city, String neighbourhood, int postalCode, String state, String street, String cpf, String pass) {

    public UserResponseDTO(Users users){
        this(users.getId(), users.getAddressNumber(), users.getCity(), users.getNeighbourhood(), users.getPostalCode(), users.getState(), users.getStreet(), users.getCpf(), users.getPass());
    }

}
