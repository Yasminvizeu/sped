package com.projetoIntegrado.sped.visit.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface VisitRepository extends JpaRepository<Visits,String> {

    Visits save(Visits visit);

}
