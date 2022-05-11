package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    Boolean save(TechnologyDto technologyDto);

    void update(Long id, TechnologyDto technologyDto);

    Boolean deleteById(Long id);

    Technology findById(Long id);

    List<Technology> findAll();
}
