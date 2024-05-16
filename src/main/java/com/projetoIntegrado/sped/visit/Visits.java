package com.projetoIntegrado.sped.visit;

import com.projetoIntegrado.sped.school.Schools;
import com.projetoIntegrado.sped.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "visits")
@Entity(name = "visits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idSchool", referencedColumnName = "id")
    private Schools school;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private Users user;

    @Column(name = "visit_Date")
    private Date visitDate;

    @Column(name = "visit_Period")
    private String visitPeriod;

    public Visits(VisitRequestDTO data) {
        this.visitDate = data.visitDate();
        this.visitPeriod = data.visitPeriod();
    }
}
