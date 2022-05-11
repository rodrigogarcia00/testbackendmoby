package com.mobytestbackend.service;

import com.mobytestbackend.exception.TechnologyNotFoundException;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    Boolean save(TechnologyDto technologyDto);

    void update(Long id, TechnologyDto technologyDto);

    void deleteById(Long id);

    Technology findById(Long id) throws TechnologyNotFoundException;

    List<Technology> findAll();
}
