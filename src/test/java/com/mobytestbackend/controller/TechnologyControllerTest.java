package com.mobytestbackend.controller;

import com.google.gson.Gson;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.TechnologyDto;
import com.mobytestbackend.service.TechnologyService;
import org.junit.jupiter.api.BeforeEach;
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
public class TechnologyControllerTest {
    @Mock
    TechnologyService technologyService;

    @Autowired
    protected MockMvc mockMvc;

    private Technology technology;

    private TechnologyDto technologyDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        technologyDto = TechnologyDto.builder().description("java").version("15").build();
        technology = Technology.builder().id(1L).description("java").version("15").build();
    }

    @Test
    public void saveTest() throws Exception {
        when(technologyService.save(technologyDto)).thenReturn(true);
        String technologyDtoJson = new Gson().toJson(technologyDto);
        mockMvc.perform(post("/technology/save").contentType(MediaType.APPLICATION_JSON).content(technologyDtoJson)).andExpect(status().isCreated());
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/technology/{id}", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void findAllTest() throws Exception {
        List<Technology> technologyList = new ArrayList<>();
        when(technologyService.findAll()).thenReturn(technologyList);
        mockMvc.perform(get("/technology/findAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
