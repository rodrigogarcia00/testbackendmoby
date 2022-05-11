package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.projection.CandidateByTechnologyProjection;
import com.mobytestbackend.repository.CandidateByTechnologyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateByTechnologyServiceImplTest {
    @InjectMocks
    CandidateByTechnologyServiceImpl candidateByTechnologyServiceImpl;

    @Mock
    CandidateByTechnologyRepository candidateByTechnologyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Disabled
    void saveTest() {
    }

    @Test
    void deleteByIdTest() {
        candidateByTechnologyServiceImpl.deleteById(1L);
        verify(candidateByTechnologyRepository, times(1)).deleteById(1L);
    }

    @Test
    void findAllTest() {
        List<CandidateByTechnology> candidateByTechnologyList = new ArrayList<>();
        when(candidateByTechnologyRepository.findAll()).thenReturn(candidateByTechnologyList);
        List<CandidateByTechnology> candidateByTechnologies = candidateByTechnologyServiceImpl.findAll();
        verify(candidateByTechnologyRepository, times(1)).findAll();
        assertEquals(candidateByTechnologyList, candidateByTechnologies);
    }

    @Test
    void findByIdTest() {
        CandidateByTechnology candidateByTechnology = CandidateByTechnology.builder().id(1L).build();
        when(candidateByTechnologyRepository.findById(1L)).thenReturn(Optional.ofNullable(candidateByTechnology));
        CandidateByTechnology candidateByTechnologyExpected = candidateByTechnologyServiceImpl.findById(1L);
        assertEquals(candidateByTechnology, candidateByTechnologyExpected);
    }

    @Test
    void listByTechnologyNameTest() {
        List<CandidateByTechnologyProjection> candidateByTechnologyProjectionList = new ArrayList<>();
        when(candidateByTechnologyRepository.listByNameTechnology("java")).thenReturn(candidateByTechnologyProjectionList);
        List<CandidateByTechnologyProjection> projectionList = candidateByTechnologyServiceImpl.listByTechnologyName("java");
        verify(candidateByTechnologyRepository, times(1)).listByNameTechnology("java");
        assertEquals(candidateByTechnologyProjectionList, projectionList);
    }
}