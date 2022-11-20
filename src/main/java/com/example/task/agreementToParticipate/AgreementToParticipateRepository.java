package com.example.task.agreementToParticipate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgreementToParticipateRepository extends JpaRepository<AgreementToParticipate, Long> {

    Optional<AgreementToParticipate> findAgreementToParticipateById(Long id);

    Optional<AgreementToParticipate> findAgreementToParticipateByPersonIdAndResearchProjectId(Long personId, Long researchProjectId);

}
