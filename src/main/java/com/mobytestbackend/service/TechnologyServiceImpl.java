package com.mobytestbackend.service;

import com.mobytestbackend.exception.CandidateAlreadyExist;
import com.mobytestbackend.exception.TechnologyNotFoundException;
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
    private Technology uploadTechnology(TechnologyDto technologyDto) {
        Technology technology = Technology.builder()
                .description(technologyDto.getDescription())
                .version(technologyDto.getVersion())
                .build();
        return technologyRepository.save(technology);

    }

    @Override
    public void update(Long id, TechnologyDto technologyDto) {
        Technology technology = technologyRepository.findById(id).get();
        if (technologyDto.getDescription() != null && !technologyDto.getDescription().equals("")) {
            technology.setDescription(technologyDto.getDescription());
        }
        if (technologyDto.getVersion() != null && !technologyDto.getVersion().equals("")) {
            technology.setVersion(technologyDto.getVersion());
        }
        technologyRepository.save(technology);
    }

    @Override
    public void deleteById(Long id) {
        try {
            technologyRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();

        }
    }

    @Override
    public Technology findById(Long id) throws TechnologyNotFoundException {
        return technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("Technology not found - id: " + id));
    }

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }
}
