package com.mobytestbackend.controller;

import com.mobytestbackend.exception.TechnologyNotFoundException;
import com.mobytestbackend.models.entity.Technology;
import com.mobytestbackend.models.views.TechnologyDto;
import com.mobytestbackend.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @PostMapping(value = "/save")
    public ResponseEntity<Boolean> saveTechnology(@RequestBody TechnologyDto technologyDto) {
        return new ResponseEntity<>(technologyService.save(technologyDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTechnology(@PathVariable Long id) {
        technologyService.deleteById(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable Long id) throws TechnologyNotFoundException {
        return new ResponseEntity<>(technologyService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Technology>> findAll() {
        return new ResponseEntity<>(technologyService.findAll(), HttpStatus.OK);
    }
}
