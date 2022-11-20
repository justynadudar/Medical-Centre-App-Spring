package com.example.task.laboratoryTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "laboratoryTest")
public class LaboratoryTestController {

    private final LaboratoryTestService laboratoryTestService;

    @Autowired
    public LaboratoryTestController(LaboratoryTestService laboratoryTestService) {
        this.laboratoryTestService = laboratoryTestService;
    }

    @PostMapping(path = "add")
    public void addLaboratoryTest(@RequestBody @Valid LaboratoryTest laboratoryTest) {
        laboratoryTestService.addLaboratoryTest(laboratoryTest);
    }

    @GetMapping
    public List<LaboratoryTest> getLaboratoryTest() {
        return laboratoryTestService.getLaboratoryTest();
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteLaboratoryTest(@PathVariable Long id) {
        laboratoryTestService.deleteLaboratoryTest(id);
    }

    @PutMapping(path = "edit/{id}")
    public void updateLaboratoryTest(@PathVariable Long id, @RequestBody LaboratoryTest laboratoryTest) {
        laboratoryTestService.updateLaboratoryTest(id, laboratoryTest);
    }

    @PutMapping(path = "uploadFile/{id}")
    public void uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            laboratoryTestService.uploadFile(id, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
