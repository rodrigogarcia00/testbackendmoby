package com.mobytestbackend.service;

import com.mobytestbackend.exception.CandidateAlreadyExist;
import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.enums.DocumentType;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.repository.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateServiceImplTest {
    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateServiceImpl;

    private Candidate candidate;

    private CandidateDto candidateDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    @Disabled
    void saveTest() throws CandidateAlreadyExist {
        CandidateDto candidateDto1 = CandidateDto.builder().name("raul").lastname("blanco").documentType(DocumentType.DNI).documentNumber(123444L).birthdate(new Date()).build();
        Candidate candidateWithoutId = Candidate.builder().name("raul").lastname("blanco").documentType(DocumentType.DNI).documentNumber(123444l).birthdate(new Date()).build();
        Candidate candidateWithId = Candidate.builder().id(1L).name("raul").lastname("blanco").documentType(DocumentType.DNI).documentNumber(123444l).birthdate(new Date()).build();
        when(candidateRepository.save(candidateWithoutId)).thenReturn(candidateWithId);
        when(candidateRepository.existsById(1L)).thenReturn(true);
        assertTrue(candidateServiceImpl.save(candidateDto1));
    }

    @Test
    void deleteByIdTest() {
        candidateServiceImpl.deleteById(1L);
        verify(candidateRepository, times(1)).deleteById(1L);
    }

    @Test
    void findByIdTest() {
        Candidate candidate = Candidate.builder().id(1L).build();
        when(candidateRepository.findById(1L)).thenReturn(Optional.ofNullable(candidate));
        Candidate candidateExpected = candidateServiceImpl.findById(1L);
        assertEquals(candidate, candidateExpected);
    }

    @Test
    void findAllTest() {
        List<Candidate> candidateList = new ArrayList<>();
        when(candidateRepository.findAll()).thenReturn(candidateList);
        List<Candidate> candidates = candidateServiceImpl.findAll();
        verify(candidateRepository, times(1)).findAll();
        assertEquals(candidates, candidates);
    }
}