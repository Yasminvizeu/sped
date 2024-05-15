package com.projetoIntegrado.sped.school;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SchoolRepository extends JpaRepository<Schools,String> {


//    @Modifying
//    @Transactional
//    @Query("UPDATE Schools s SET s.selected = true WHERE s.id = :schoolId")
//    void selectSchools(@Param("schoolId") Long schoolId);
}
