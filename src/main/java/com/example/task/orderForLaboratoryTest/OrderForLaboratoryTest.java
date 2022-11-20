package com.example.task.orderForLaboratoryTest;

import com.example.task.laboratoryTest.LaboratoryTest;
import com.example.task.person.Person;
import com.example.task.researchProject.ResearchProject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class OrderForLaboratoryTest {

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Person patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordering_doctor_id")
    private Person orderingDoctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "research_project_id")
    private ResearchProject researchProject;

    @NotNull
    private Timestamp testDate;

    @JsonIgnore
    @OneToOne(mappedBy = "orderForLaboratoryTest")
    private LaboratoryTest laboratoryTest;

    public OrderForLaboratoryTest() {
    }

    public OrderForLaboratoryTest(Person patient, Person orderingDoctor, ResearchProject researchProject, Timestamp testDate) {
        this.patient = patient;
        this.orderingDoctor = orderingDoctor;
        this.researchProject = researchProject;
        this.testDate = testDate;
    }

    public OrderForLaboratoryTest(Long id, Person patient, Person orderingDoctor, ResearchProject researchProject, Timestamp testDate) {
        this.id = id;
        this.patient = patient;
        this.orderingDoctor = orderingDoctor;
        this.researchProject = researchProject;
        this.testDate = testDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    public Person getOrderingDoctor() {
        return orderingDoctor;
    }

    public void setOrderingDoctor(Person orderingDoctor) {
        this.orderingDoctor = orderingDoctor;
    }

    public Timestamp getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp test_date) {
        this.testDate = test_date;
    }

    public ResearchProject getResearchProject() {
        return researchProject;
    }

    public void setResearchProject(ResearchProject researchProject) {
        this.researchProject = researchProject;
    }

    public LaboratoryTest getLaboratoryTest() {
        return laboratoryTest;
    }

    public void setLaboratoryTest(LaboratoryTest laboratoryTest) {
        this.laboratoryTest = laboratoryTest;
    }
}
