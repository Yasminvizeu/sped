package com.projetoIntegrado.sped.userRoles;

import com.projetoIntegrado.sped.user.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "user_roles")
@Entity(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    public UserRoles(UserRolesRequestDTO data){
        this.roleName = data.roleName();
    }


}
