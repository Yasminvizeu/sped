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
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "urgent_call")
    private Boolean urgentCall;

    @Column(name = "securityLevel")
    private int securityLevel;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "selected_for_visit")
    private Boolean selected;

    public Schools(SchoolRequestDTO data) {
        this.name = data.name();
        this.urgentCall = data.urgentCall();
        this.securityLevel = data.securityLevel();
        this.latitude = data.latitude();
        this.longitude = data.longitude();
        this.selected = data.selected();
    }
}
