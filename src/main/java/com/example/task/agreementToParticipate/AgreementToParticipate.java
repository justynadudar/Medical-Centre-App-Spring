package com.example.task.agreementToParticipate;

import com.example.task.person.Person;
import com.example.task.researchProject.ResearchProject;

import javax.persistence.*;

@Entity
@Table
public class AgreementToParticipate {
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
    @JoinColumn(name = "person_agreements")
    private Person person;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "research_project_agreements")
    private ResearchProject researchProject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ResearchProject getResearchProject() {
        return researchProject;
    }

    public void setResearchProject(ResearchProject researchProject) {
        this.researchProject = researchProject;
    }


    @Override
    public String toString() {
        return "AgreementToParticipate{" +
                "id=" + id +
                ", person=" + person +
                ", researchProject=" + researchProject +
                '}';
    }
}
