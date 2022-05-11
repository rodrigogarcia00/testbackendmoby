package com.mobytestbackend.service;

import com.mobytestbackend.exception.TechnologyNotFoundException;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.repository.TechnologyRepository;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TechnologyServiceImplTest {
    @InjectMocks
    TechnologyServiceImpl technologyServiceImpl;

    @Mock
    TechnologyRepository technologyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Disabled
    public void saveTest() {
    }

    @Test
    public void deleteByIdTest() {
        technologyServiceImpl.deleteById(1L);
        verify(technologyRepository, times(1)).deleteById(1L);
    }

    @Test
    public void findAllTest() {
        List<Technology> technologyList = new ArrayList<>();
        when(technologyRepository.findAll()).thenReturn(technologyList);
        List<Technology> technologies = technologyServiceImpl.findAll();
        verify(technologyRepository, times(1)).findAll();
        assertEquals(technologyList, technologies);
    }

    @Test
    public void findByIdTest() throws TechnologyNotFoundException {
        Technology technology = Technology.builder().id(1L).build();
        when(technologyRepository.findById(1L)).thenReturn(Optional.ofNullable(technology));
        Technology technologyExpected = technologyServiceImpl.findById(1L);
        assertEquals(technology, technologyExpected);
    }

    @Test
    public void findByIdException(){
        Technology technology = Technology.builder().id(1L).description("java").version("8").build();
        Long technologyId=technology.getId();
        when(technologyRepository.findById(technology.getId())).thenThrow(TechnologyNotFoundException.class);
        assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImpl.findById(technologyId));
    }

}