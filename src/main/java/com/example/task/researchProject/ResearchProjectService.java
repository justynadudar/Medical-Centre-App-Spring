package com.example.task.researchProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResearchProjectService {

    private final ResearchProjectRepository researchProjectRepository;

    @Autowired
    public ResearchProjectService(ResearchProjectRepository researchProjectRepository) {
        this.researchProjectRepository = researchProjectRepository;
    }

    public void addResearchProject(ResearchProject researchProject) {
        researchProjectRepository.save(researchProject);
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjectRepository.findAll();
    }

    public ResearchProject getResearchProjectById(Long id) {
        return researchProjectRepository.findResearchProjectById(id).orElseThrow(() -> new IllegalStateException("Research Project  with id " + id + " does not exists"));
    }

    public void deleteResearchProject(Long id) {
        researchProjectRepository.findResearchProjectById(id).orElseThrow(() -> new IllegalStateException("ResearchProject with id " + id + " does not exists"));
        researchProjectRepository.deleteById(id);
    }

    public void updateResearchProject(Long id, ResearchProject researchProject) {
        researchProjectRepository.findById(id).orElseThrow(() -> new IllegalStateException("ResearchProject with id " + id + " does not exists"));
        researchProject.setId(id);
        researchProjectRepository.save(researchProject);
    }
}
