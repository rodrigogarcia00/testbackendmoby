package com.mobytestbackend.models.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateByTechnologyDto {

    private Long candidateId;
    private Long technologyId;
    private Integer yearsExperience;
}
