package com.mobytestbackend.service;

import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.TechnologyDto;
import com.mobytestbackend.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;


    @Override
    public Boolean save(TechnologyDto technologyDto) {
        Long id = uploadTechnology(technologyDto).getId();
        return technologyRepository.existsById(id);
    }

    @Override
    public void update(Long id, TechnologyDto technologyDto) {
        Technology technology = technologyRepository.findById(id).get();
        if (technologyDto.getName() != null && !technologyDto.getName().equals("")) {
            technology.setName(technologyDto.getName());
        }
        if (technologyDto.getVersion() != null && !technologyDto.getVersion().equals("")) {
            technology.setVersion(technologyDto.getVersion());
        }
        technologyRepository.save(technology);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            technologyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public Technology findById(Long id) {
        return technologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la tecnologia - id: " + id));
    }

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    private Technology uploadTechnology(TechnologyDto technologyDto) {
        Technology technology = Technology.builder()
                .name(technologyDto.getName())
                .version(technologyDto.getVersion())
                .build();
        return technologyRepository.save(technology);

    }
}
