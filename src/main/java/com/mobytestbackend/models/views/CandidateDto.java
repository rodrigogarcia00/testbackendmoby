package com.mobytestbackend.models.views;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mobytestbackend.models.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDto {
    private String name;
    private String lastname;
    private DocumentType documentType;
    private Long documentNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-Arg", timezone = "America/Buenos Aires")
    private Date birthdate;
    List<TechnologyDto> technologyDtoList;
}
