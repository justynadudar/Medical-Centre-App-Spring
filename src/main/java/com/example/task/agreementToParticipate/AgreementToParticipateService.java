package com.example.task.agreementToParticipate;

import com.example.task.person.Person;
import com.example.task.person.PersonRepository;
import com.example.task.researchProject.ResearchProject;
import com.example.task.researchProject.ResearchProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgreementToParticipateService {

    private final AgreementToParticipateRepository agreementToParticipateRepository;
    private final PersonRepository personRepository;
    private final ResearchProjectRepository researchProjectRepository;

    @Autowired
    public AgreementToParticipateService(AgreementToParticipateRepository agreementToParticipateRepository, PersonRepository personRepository, ResearchProjectRepository researchProjectRepository) {
        this.agreementToParticipateRepository = agreementToParticipateRepository;
        this.personRepository = personRepository;
        this.researchProjectRepository = researchProjectRepository;
    }

    public void addAgreementToParticipate(AgreementToParticipate agreementToParticipate) {
        Person personToAssign = personRepository.findPersonById(agreementToParticipate.getPerson().getId()).orElseThrow(() -> new IllegalStateException("Person with id " + agreementToParticipate.getPerson().getId() + " does not exists"));
        ResearchProject researchProjectToAssign = researchProjectRepository.findResearchProjectById(agreementToParticipate.getResearchProject().getId()).orElseThrow(() -> new IllegalStateException("Research Project with id " + agreementToParticipate.getResearchProject().getId() + " does not exists"));

        agreementToParticipate.setPerson(personToAssign);
        agreementToParticipate.setResearchProject(researchProjectToAssign);
        agreementToParticipateRepository.save(agreementToParticipate);
    }

    public List<AgreementToParticipate> getAgreementsToParticipate() {
        return agreementToParticipateRepository.findAll();
    }

    public AgreementToParticipate getAgreementToParticipateById(Long id) {
        return agreementToParticipateRepository.findAgreementToParticipateById(id).orElseThrow(() -> new IllegalStateException("Agreement To Participate with id " + id + " does not exists"));
    }

    public AgreementToParticipate getAgreementToParticipateByPersonIdAndResearchProjectId(Long personId, Long researchProjectId) {
        return agreementToParticipateRepository.findAgreementToParticipateByPersonIdAndResearchProjectId(personId, researchProjectId).orElseThrow(() -> new IllegalStateException("Agreement To Participate with person id " + personId + " and research project id " + researchProjectId + " does not exists"));
    }

    public void deleteAgreementToParticipate(Long id) {
        agreementToParticipateRepository.findAgreementToParticipateById(id).orElseThrow(() -> new IllegalStateException("Agreement To Participate with id " + id + " does not exists"));
        agreementToParticipateRepository.deleteById(id);
    }
}
