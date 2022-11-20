package com.example.task.orderForLaboratoryTest;

import com.example.task.agreementToParticipate.AgreementToParticipateRepository;
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
public class OrderForLaboratoryTestService {

    private final OrderForLaboratoryTestRepository orderForLaboratoryTestRepository;
    private final PersonRepository personRepository;
    private final ResearchProjectRepository researchProjectRepository;
    private final AgreementToParticipateRepository agreementToParticipateRepository;

    @Autowired
    public OrderForLaboratoryTestService(OrderForLaboratoryTestRepository orderForLaboratoryTestRepository, PersonRepository personRepository, ResearchProjectRepository researchProjectRepository, AgreementToParticipateRepository agreementToParticipateRepository) {
        this.orderForLaboratoryTestRepository = orderForLaboratoryTestRepository;
        this.personRepository = personRepository;
        this.researchProjectRepository = researchProjectRepository;
        this.agreementToParticipateRepository = agreementToParticipateRepository;
    }

    public void addOrderForLaboratoryTest(OrderForLaboratoryTest orderForLaboratoryTest) {
        Person patientToAssign = personRepository.findPersonById(orderForLaboratoryTest.getPatient().getId()).orElseThrow(() -> new IllegalStateException("Person with id " + orderForLaboratoryTest.getPatient().getId() + " does not exists"));
        Person orderingDoctorToAssign = personRepository.findPersonById(orderForLaboratoryTest.getOrderingDoctor().getId()).orElseThrow(() -> new IllegalStateException("Person with id " + orderForLaboratoryTest.getOrderingDoctor().getId() + " does not exists"));
        ResearchProject researchProjectToAssign = researchProjectRepository.findResearchProjectById(orderForLaboratoryTest.getResearchProject().getId()).orElseThrow(() -> new IllegalStateException("Research Project with id " + orderForLaboratoryTest.getResearchProject().getId() + " does not exists"));

        agreementToParticipateRepository.findAgreementToParticipateByPersonIdAndResearchProjectId(patientToAssign.getId(), researchProjectToAssign.getId()).orElseThrow(() -> new IllegalStateException("Person with id " + orderForLaboratoryTest.getPatient().getId() + " have not agreement to participate in research project with id " + orderForLaboratoryTest.getResearchProject().getId()));

        orderForLaboratoryTest.setPatient(patientToAssign);
        orderForLaboratoryTest.setOrderingDoctor(orderingDoctorToAssign);
        orderForLaboratoryTest.setResearchProject(researchProjectToAssign);

        orderForLaboratoryTestRepository.save(orderForLaboratoryTest);
    }

    public List<OrderForLaboratoryTest> getOrdersForLaboratoryTest() {
        return orderForLaboratoryTestRepository.findAll();
    }

    public OrderForLaboratoryTest getOrdersForLaboratoryTestById(Long id) {
        return orderForLaboratoryTestRepository.findOrderForLaboratoryTestById(id).orElseThrow(() -> new IllegalStateException("Order For Laboratory Test with id " + id + " does not exists"));
    }
}
