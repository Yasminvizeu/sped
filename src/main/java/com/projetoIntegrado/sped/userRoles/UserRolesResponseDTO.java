package com.projetoIntegrado.sped.userRoles;

import com.projetoIntegrado.sped.user.Users;

public record UserRolesResponseDTO(Long id, String roleName) {

    public UserRolesResponseDTO(UserRoles userRoles){

        this(userRoles.getId(), userRoles.getRoleName());
    }

}
