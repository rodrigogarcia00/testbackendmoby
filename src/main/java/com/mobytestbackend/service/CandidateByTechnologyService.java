package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.models.views.CandidateByTechnologyDto;

import java.util.List;

public interface CandidateByTechnologyService {
    CandidateByTechnology save(CandidateByTechnologyDto candidateByTechnologyDto);

    Boolean deleteById(Long id);

    List<CandidateByTechnology> findAll();

    CandidateByTechnology findById(Long id);

    List<CandidateByTechnology> listByTechnologyName(String technologyName);

}
