package com.mobytestbackend.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_by_technology")
public class CandidateByTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidate", referencedColumnName = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "id_technology", referencedColumnName = "technology_id")
    private Technology technology;

    @Column(name = "years_experience", nullable = false)
    private Integer yearsExperience;
}
