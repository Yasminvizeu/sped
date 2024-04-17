package com.projetoIntegrado.sped.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users,String> {

    Users findIdByCpf(String cpf);
    UserDetails findByCpf(String cpf);

}
