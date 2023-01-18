package com.umutdoruk.hrms.repository;

import com.umutdoruk.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    List<Education> findAllByOrderByGraduationDateAsc();
    List<Education> findAllByOrderByGraduationDateDesc();
}
