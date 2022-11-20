package com.example.task.laboratoryTest;

import com.example.task.orderForLaboratoryTest.OrderForLaboratoryTest;
import com.example.task.orderForLaboratoryTest.OrderForLaboratoryTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LaboratoryTestService {

    private final LaboratoryTestRepository laboratoryTestRepository;
    private final OrderForLaboratoryTestRepository orderForLaboratoryTestRepository;

    @Autowired
    public LaboratoryTestService(LaboratoryTestRepository laboratoryTestRepository, OrderForLaboratoryTestRepository orderForLaboratoryTestRepository) {
        this.laboratoryTestRepository = laboratoryTestRepository;
        this.orderForLaboratoryTestRepository = orderForLaboratoryTestRepository;
    }

    public void addLaboratoryTest(LaboratoryTest laboratoryTest) {
        OrderForLaboratoryTest orderForLaboratoryTestToAssign = orderForLaboratoryTestRepository.findOrderForLaboratoryTestById(laboratoryTest.getOrderForLaboratoryTest().getId()).orElseThrow(() -> new IllegalStateException("Order For Laboratory Test with id " + laboratoryTest.getOrderForLaboratoryTest().getId() + " does not exists"));
        laboratoryTest.setOrderForLaboratoryTest(orderForLaboratoryTestToAssign);
        laboratoryTestRepository.save(laboratoryTest);
    }

    public List<LaboratoryTest> getLaboratoryTest() {
        return laboratoryTestRepository.findAll();
    }

    public LaboratoryTest getLaboratoryTestById(Long id) {
        return laboratoryTestRepository.findLaboratoryTestById(id).orElseThrow(() -> new IllegalStateException("Laboratory Test with id " + id + " does not exists"));
    }

    public void deleteLaboratoryTest(Long id) {
        laboratoryTestRepository.findLaboratoryTestById(id).orElseThrow(() -> new IllegalStateException("Laboratory Test with id " + id + " does not exists"));
        laboratoryTestRepository.deleteById(id);
    }

    public void updateLaboratoryTest(Long id, LaboratoryTest laboratoryTest) {
        laboratoryTestRepository.findById(id).orElseThrow(() -> new IllegalStateException("Laboratory Test with id " + id + " does not exists"));
        laboratoryTest.setId(id);
        laboratoryTestRepository.save(laboratoryTest);
    }

    public void uploadFile(Long id, byte[] file) {
        LaboratoryTest laboratoryTest = laboratoryTestRepository.findById(id).orElseThrow(() -> new IllegalStateException("Laboratory Test with id " + id + " does not exists"));
        laboratoryTest.setTestFile(file);
        laboratoryTestRepository.save(laboratoryTest);
    }
}
