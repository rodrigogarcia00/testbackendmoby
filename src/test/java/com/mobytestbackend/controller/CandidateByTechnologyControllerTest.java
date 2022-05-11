package com.mobytestbackend.controller;


import com.google.gson.Gson;
import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.CandidateByTechnologyDto;
import com.mobytestbackend.projection.CandidateByTechnologyProjection;
import com.mobytestbackend.service.CandidateByTechnologyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CandidateByTechnologyControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Mock
    private CandidateByTechnologyService candidateByTechnologyService;

    private CandidateByTechnologyDto candidateByTechnologyDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    @Disabled
    void saveTest() throws Exception {
        Candidate candidateDos = Candidate.builder().id(1L).build();
        Technology technologyDos = Technology.builder().id(1L).build();
        CandidateByTechnology candidateByTechnology = CandidateByTechnology.builder()
                .id(1L)
                .candidate(candidateDos)
                .technology(technologyDos)
                .yearsExperience(3)
                .build();

        CandidateByTechnologyDto candidateByTechnologyDtoDos =
                CandidateByTechnologyDto.builder()
                        .candidateId(1L)
                        .technologyId(1L)
                        .yearsExperience(3)
                        .build();
        when(candidateByTechnologyService.save(candidateByTechnologyDtoDos)).thenReturn(candidateByTechnology);
        String candidateByTechnologyDtoJson = new Gson().toJson(candidateByTechnologyDto);
        mockMvc.perform(post("/candidateByTechnology/save").contentType(MediaType.APPLICATION_JSON)
                .content(candidateByTechnologyDtoJson)).andExpect(status().isCreated());
    }

    @Test
    @Disabled
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/candidateByTechnology/{id}", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void findAllTest() throws Exception {
        List<CandidateByTechnology> candidateByTechnologyList = new ArrayList<>();
        when(candidateByTechnologyService.findAll()).thenReturn(candidateByTechnologyList);
        mockMvc.perform(get("/candidateByTechnology/findAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void listByTechnologyNameTest() throws Exception {
        List<CandidateByTechnologyProjection> candidateByTechnologyProjectionList = new ArrayList<>();
        when(candidateByTechnologyService.listByTechnologyName("java")).thenReturn(candidateByTechnologyProjectionList);
        mockMvc.perform(get("/candidateByTechnology/listByTechnologyName/{nameTechnology}", "java").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}