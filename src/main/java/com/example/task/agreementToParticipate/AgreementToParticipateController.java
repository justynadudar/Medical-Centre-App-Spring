package com.example.task.agreementToParticipate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "agreementToParticipate")
public class AgreementToParticipateController {

    private final AgreementToParticipateService agreementToParticipateService;

    @Autowired
    public AgreementToParticipateController(AgreementToParticipateService agreementToParticipateService) {
        this.agreementToParticipateService = agreementToParticipateService;
    }

    @PostMapping(path = "add")
    public void addAgreementToParticipate(@RequestBody @Valid AgreementToParticipate agreementToParticipate) {
        agreementToParticipateService.addAgreementToParticipate(agreementToParticipate);
    }

    @GetMapping
    public List<AgreementToParticipate> getAgreementsToParticipate() {
        return agreementToParticipateService.getAgreementsToParticipate();
    }

    @GetMapping(path = "{personId}/{researchProjectId}")
    public AgreementToParticipate getAgreementToParticipateByPersonId(@PathVariable("personId") Long personId, @PathVariable("researchProjectId") Long researchProjectId) {
        return agreementToParticipateService.getAgreementToParticipateByPersonIdAndResearchProjectId(personId, researchProjectId);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteAgreementToParticipate(@PathVariable Long id) {
        agreementToParticipateService.deleteAgreementToParticipate(id);
    }

}

