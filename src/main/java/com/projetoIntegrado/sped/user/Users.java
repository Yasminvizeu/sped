package com.projetoIntegrado.sped.user;

import com.projetoIntegrado.sped.school.Schools;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {
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
    private String cpf;

    @Column(name = "pass")
    private String pass;

    @Column(name = "role")
    private String role;



    public Users(UserRequestDTO data){
        this.addressNumber = data.addressNumber();
        this.city = data.city();
        this.neighbourhood = data.neighbourhood();
        this.postalCode = data.postalCode();
        this.state = data.state();
        this.street = data.street();
        this.cpf = data.cpf();
        this.pass = data.pass();
        this.role = data.role();
    }
    public Users(String cpf, String pass, String role){
        this.cpf = cpf;
        this.pass = pass;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String ur = userRole.ADMIN.toString();
        if(this.role.equals(ur))return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
