package com.example.task.researchProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResearchProjectRepository extends JpaRepository<ResearchProject, Long> {

    Optional<ResearchProject> findResearchProjectById(Long id);

}
