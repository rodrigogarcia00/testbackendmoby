package com.mobytestbackend.service;

import com.mobytestbackend.exception.CandidateAlreadyExist;
import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    @Transactional
    public Boolean save(CandidateDto candidateDto) throws CandidateAlreadyExist {
        return uploadCandidate(candidateDto);
    }

    private Boolean uploadCandidate(CandidateDto candidateDto) throws CandidateAlreadyExist {
        Candidate candidate = Candidate.builder()
                .name(candidateDto.getName())
                .lastname(candidateDto.getLastname())
                .documentType(candidateDto.getDocumentType())
                .documentNumber(candidateDto.getDocumentNumber())
                .birthdate(candidateDto.getBirthdate())
                .build();
        candidateRepository.save(candidate);
        Candidate candidatoEncontrado = candidateRepository.findByDocument(candidateDto.getDocumentNumber());
        if (candidatoEncontrado==null) {
            throw new CandidateAlreadyExist("Candidate already exists - documentNumber:"+candidateDto.getDocumentNumber());
        }
        return true;
    }

    @Override
    public void deleteById(Long id) {
        try {
            candidateRepository.deleteById(id);

        } catch (Exception e) {
            e.getMessage();

        }
    }

    @Override
    @Transactional
    public Candidate findById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el candidato: " + id));
    }

    @Override
    @Transactional
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

}
