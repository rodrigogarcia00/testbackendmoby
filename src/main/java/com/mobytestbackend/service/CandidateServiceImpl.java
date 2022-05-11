package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Boolean save(CandidateDto candidateDto) {
        return uploadCandidate(candidateDto);
    }

    @Override
    public void update(Long id, CandidateDto candidateDto) {
        Candidate candidate = candidateRepository.findById(id).get();
        if (candidateDto.getName() != null && !candidateDto.getName().equals("")) {
            candidate.setName(candidateDto.getName());
        }
        if (candidateDto.getLastname() != null && !candidateDto.getLastname().equals("")) {
            candidate.setLastname(candidateDto.getLastname());
        }
        if (candidateDto.getDocumentType() != null && !candidateDto.getDocumentType().equals("")) {
            candidate.setDocumentType(candidateDto.getDocumentType());
        }
        if (candidateDto.getDocumentNumber() != null && !candidateDto.getDocumentNumber().equals("")) {
            candidate.setDocumentNumber(candidateDto.getDocumentNumber());
        }
        if (candidateDto.getBirthdate() != null && !candidateDto.getBirthdate().equals("")) {
            candidate.setBirthdate(candidateDto.getBirthdate());
        }
        candidateRepository.save(candidate);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            candidateRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el Candidate - id: " + id));
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    private Boolean uploadCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .name(candidateDto.getName())
                .lastname(candidateDto.getLastname())
                .documentType(candidateDto.getDocumentType())
                .documentNumber(candidateDto.getDocumentNumber())
                .birthdate(candidateDto.getBirthdate())
                .build();
        candidateRepository.save(candidate);
        Candidate candidatoEncontrado = candidateRepository.findByDocument(candidateDto.getDocumentNumber());
        if (candidatoEncontrado == null) {
            return false;
        }
        return true;
    }
}
