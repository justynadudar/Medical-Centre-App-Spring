package com.example.task.laboratoryTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaboratoryTestRepository extends JpaRepository<LaboratoryTest, Long> {

    Optional<LaboratoryTest> findLaboratoryTestById(Long id);
}
