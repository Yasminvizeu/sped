package com.projetoIntegrado.sped.occurence;

import com.projetoIntegrado.sped.school.Schools;
import com.projetoIntegrado.sped.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "occurences")
@Entity(name = "ocurrences")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Occurences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "userName")
    private String user_Name;

    @Column(name = "schoolName")
    private String schoolName;

    @Column(name = "visitPeriod")
    private String visitPeriod;

    @Column(name = "description")
    private String description;

    public Occurences(OccurenceRequestDTO data) {
        this.code = data.code();
        this.user_Name = data.user_Name();
        this.schoolName = data.schoolName();
        this.visitPeriod = data.visitPeriod();
        this.description = data.description();
    }
}
