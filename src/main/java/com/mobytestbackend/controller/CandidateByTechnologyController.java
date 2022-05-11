package com.mobytestbackend.controller;

import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.models.views.CandidateByTechnologyDto;
import com.mobytestbackend.service.CandidateByTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/candidateByTechnology")
public class CandidateByTechnologyController {
    @Autowired
    CandidateByTechnologyService candidateByTechnologyService;

    @GetMapping(value = "/save")
    public ResponseEntity<CandidateByTechnology> save(@RequestBody CandidateByTechnologyDto candidateByTechnologyDto) {

        return new ResponseEntity<>(candidateByTechnologyService.save(candidateByTechnologyDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        return new ResponseEntity<>(candidateByTechnologyService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CandidateByTechnology> getById(@PathVariable Long id) {
        return new ResponseEntity<>(candidateByTechnologyService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/listByTechnologyName/{nameTechnology}")
    public ResponseEntity<List<CandidateByTechnology>> listByTechnologyName(@PathVariable String nameTechnology) {
        return new ResponseEntity<>(candidateByTechnologyService.listByTechnologyName(nameTechnology), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<CandidateByTechnology>> findAll() {
        return new ResponseEntity<>(candidateByTechnologyService.findAll(), HttpStatus.OK);
    }
}
