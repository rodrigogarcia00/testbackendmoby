package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.CandidateByTechnologyDto;
import com.mobytestbackend.projection.CandidateByTechnologyProjection;
import com.mobytestbackend.repository.CandidateByTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CandidateByTechnologyServiceImpl implements CandidateByTechnologyService {
    @Autowired
    CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Override
    public CandidateByTechnology save(CandidateByTechnologyDto candidateByTechnologyDto) {
        Candidate candidate = Candidate.builder().id(candidateByTechnologyDto.getCandidateId()).build();
        Technology technology = Technology.builder().id(candidateByTechnologyDto.getTechnologyId()).build();
        CandidateByTechnology candidateByTechnology = CandidateByTechnology.builder()
                .candidate(candidate).technology(technology).yearsExperience(candidateByTechnologyDto.getYearsExperience()).build();
        return candidateByTechnologyRepository.save(candidateByTechnology);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            candidateByTechnologyRepository.deleteById(id);
            return true;
        } catch (EntityNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public List<CandidateByTechnology> findAll() {
        return candidateByTechnologyRepository.findAll();
    }

    @Override
    public CandidateByTechnology findById(Long id) {
        return candidateByTechnologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró al CandidateByTechnology - id: " + id));
    }

    @Override
    public List<CandidateByTechnologyProjection> listByTechnologyName(String technologyName) {
        List<CandidateByTechnologyProjection> list = candidateByTechnologyRepository.listByNameTechnology(technologyName);
        return list;
    }
}