package com.projetoIntegrado.sped.user;

import com.projetoIntegrado.sped.userRoles.UserRoles;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_number")
    private int addressNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "cpf")
    private int cpf;

    @Column(name = "pass")
    private String pass;


    public Users(UserRequestDTO data){
        this.addressNumber = data.addressNumber();
        this.city = data.city();
        this.neighbourhood = data.neighbourhood();
        this.postalCode = data.postalCode();
        this.state = data.state();
        this.street = data.street();
        this.cpf = data.cpf();
        this.pass = data.pass();
    }


}
