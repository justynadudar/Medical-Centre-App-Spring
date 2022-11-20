package com.example.task.researchProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "researchProject")
public class ResearchProjectController {

    private final ResearchProjectService researchProjectService;

    @Autowired
    public ResearchProjectController(ResearchProjectService researchProjectService) {
        this.researchProjectService = researchProjectService;
    }

    @PostMapping(path = "add")
    public void addResearchProject(@RequestBody @Valid ResearchProject researchProject) {
        researchProjectService.addResearchProject(researchProject);
    }

    @GetMapping
    public List<ResearchProject> getResearchProjects() {
        return researchProjectService.getResearchProjects();
    }

    @GetMapping(path = "{id}")
    public ResearchProject getResearchProjectById(@PathVariable Long id) {
        return researchProjectService.getResearchProjectById(id);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        researchProjectService.deleteResearchProject(id);
    }

    @PutMapping(path = "edit/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody ResearchProject researchProject) {
        researchProjectService.updateResearchProject(id, researchProject);
    }
}
