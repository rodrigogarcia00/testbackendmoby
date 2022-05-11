package com.mobytestbackend.repository;

import com.mobytestbackend.models.entity.CandidateByTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology, Long> {

    @Query(value = "SELECT c.name, c.lastname, c.document_number, c.birthdate, t.name, t.version, ct.years_experience FROM candidate c INNER JOIN candidate_by_technology ct  ON c.candidate_id=ct.id_candidate INNER JOIN technology t ON ct.id_technology=t.technology_id WHERE t.name='?1'",nativeQuery = true)
    List<CandidateByTechnology> listByNameTechnology(String nameTechnology);
}
