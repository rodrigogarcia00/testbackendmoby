package com.mobytestbackend.repository;

import com.mobytestbackend.models.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {


}
