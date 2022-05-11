package com.mobytestbackend.controller;

import com.mobytestbackend.models.entity.Candidate;
import com.mobytestbackend.models.entity.CandidateByTechnology;
import com.mobytestbackend.models.views.CandidateDto;
import com.mobytestbackend.service.CandidateService;
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
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "/save")
    public ResponseEntity<Boolean> saveCandidate(@RequestBody CandidateDto candidateDto) {

        return new ResponseEntity<>(candidateService.save(candidateDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteCandidate(@PathVariable Long id) {

        return new ResponseEntity<>(candidateService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Candidate> getById(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Candidate>> findAll(){
        return new ResponseEntity<>(candidateService.findAll(),HttpStatus.OK);
    }



}
