package com.mobytestbackend.controller;

import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.service.CandidateService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class CandidateControllerTest {

    @Mock
    CandidateService candidateService;

    @Test
    public void testQueSeGuardeUnCandidato() {

        CandidateDto candidateDto = CandidateDto.builder().name("Rodrigo").lastname("Garcia").documentNumber(1244313L).build();
        when(candidateService.save(candidateDto)).thenReturn(true);
        //Assertions.assertTrue(Boolean.TRUE.equals(candidateController.saveCandidate(new CandidateDto().builder().name("Rodrigo").surname("Garcia").documentNumber(1244313L).build()).getBody()));
    }

    @Test
    public void testQueSeElimineUnCandidato() {

        CandidateDto candidateDto = CandidateDto.builder().name("Rodrigo").lastname("Garcia").documentNumber(1244313L).build();
        when(candidateService.deleteById(candidateDto.getDocumentNumber())).thenReturn(true);

    }

    @Test
    public void testQueSeEncuentreUnCandidatoPorId() {
        Long documentNumberTest = 1244313L;
        //when(candidateService.findById(documentNumberTest)).
        //Assertions.assertTrue(Boolean.TRUE.equals(candidateController.saveCandidate(new CandidateDto().builder().name("Rodrigo").surname("Garcia").documentNumber(1244313L).build()).getBody()));
    }

}
