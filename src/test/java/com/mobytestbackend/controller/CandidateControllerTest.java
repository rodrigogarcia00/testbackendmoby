package com.mobytestbackend.controller;

import com.google.gson.Gson;
import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.enums.DocumentType;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTest {

    @Mock
    CandidateService candidateService;

    @Autowired
    protected MockMvc mockMvc;

    private Candidate candidate;

    private CandidateDto candidateDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        candidateDto = CandidateDto.builder().name("Rodrigo").lastname("Garcia").documentType(DocumentType.DNI).documentNumber(1244313L).build();
        candidate = Candidate.builder().id(1L).name("Rodrigo").lastname("Garcia").documentType(DocumentType.DNI).documentNumber(1244313L).build();
    }

    @Test
    public void saveTest() throws Exception {

        when(candidateService.save(candidateDto)).thenReturn(true);
        String candidateDtoJson = new Gson().toJson(candidateDto);
        mockMvc.perform(post("/candidate/save").contentType(MediaType.APPLICATION_JSON).content(candidateDtoJson)).andExpect(status().isCreated());

    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/candidate/{id}", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void findAllTest() throws Exception {
        List<Candidate> candidateList = Arrays.asList(candidate);
        when(candidateService.findAll()).thenReturn(candidateList);
        mockMvc.perform(get("/candidate/findAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
