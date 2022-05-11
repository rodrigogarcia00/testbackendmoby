package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.views.CandidateDto;

import java.util.List;

public interface CandidateService {
    Boolean save(CandidateDto candidateDto);

    void update(Long id, CandidateDto candidateDto);

    Boolean deleteById(Long id);

    Candidate findById(Long id);

    List<Candidate> findAll();


}
