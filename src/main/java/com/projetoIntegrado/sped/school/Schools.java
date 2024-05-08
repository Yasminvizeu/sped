package com.projetoIntegrado.sped.school;

import com.projetoIntegrado.sped.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "schools")
@Entity(name = "schools")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Schools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "urgent_call")
    private Boolean urgentCall;

    @Column(name = "securityLevel")
    private int securityLevel;

    @Column(name = "localizacao", columnDefinition = "POINT")
    private String location;

    @Column(name = "selected_for_visit")
    private Boolean selected;

}
