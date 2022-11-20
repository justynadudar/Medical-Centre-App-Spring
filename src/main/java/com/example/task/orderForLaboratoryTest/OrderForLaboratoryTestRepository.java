package com.example.task.orderForLaboratoryTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderForLaboratoryTestRepository extends JpaRepository<OrderForLaboratoryTest, Long> {

    Optional<OrderForLaboratoryTest> findOrderForLaboratoryTestById(Long id);
}
