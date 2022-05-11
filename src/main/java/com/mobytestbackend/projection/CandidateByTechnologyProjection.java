package com.mobytestbackend.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface CandidateByTechnologyProjection {
    @Value("#{target.name}")
    String getName();

    @Value("#{target.name}")
    String setName(String name);


    @Value("#{target.lastname}")
    String getLastname();

    @Value("#{target.lastname}")
    void setLastname(String lastname);


    @Value("#{target.document_number}")
    Long getDocument_number();

    @Value("#{target.document_number}")
    void setDocument_number(Long document_number);


    @Value("#{target.birthdate}")
    Date getBirthdate();

    @Value("#{target.birthdate}")
    void setBirthdate(Date birthdate);


    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.description}")
    void setDescription(String description);


    @Value("#{target.version}")
    void setVersion(String version);

    @Value("#{target.version}")
    String getVersion();


    @Value("#{target.years_experience}")
    void setYears_experience(Integer years_experience);

    @Value("#{target.years_experience}")
    Integer getYears_experience();
}
