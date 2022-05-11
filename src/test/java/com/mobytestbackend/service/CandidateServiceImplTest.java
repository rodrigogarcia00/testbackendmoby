package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.enums.DocumentType;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.repository.CandidateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CandidateServiceImplTest {
    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateServiceImpl;

    private Candidate candidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        candidate = Candidate.builder().id(1L).name("raul").lastname("blanco").documentType(DocumentType.DNI).documentNumber(123444l).birthdate(null).build();
        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);
        assertNotNull(candidateServiceImpl.save(new CandidateDto()));
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}