package com.mobytestbackend.repository;

import com.mobytestbackend.models.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query(value = "SELECT * FROM CANDIDATE C WHERE C.document_number=?1", nativeQuery = true)
    Candidate findByDocument(Long numberDocument);

}
