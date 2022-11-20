package com.example.task.orderForLaboratoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "orderForLaboratoryTest")
public class OrderForLaboratoryTestController {


    private final OrderForLaboratoryTestService orderForLaboratoryTestService;

    @Autowired
    public OrderForLaboratoryTestController(OrderForLaboratoryTestService orderForLaboratoryTestService) {
        this.orderForLaboratoryTestService = orderForLaboratoryTestService;
    }

    @PostMapping(path = "add")
    public void addOrderForLaboratoryTest(@RequestBody @Valid OrderForLaboratoryTest orderForLaboratoryTest) {
        orderForLaboratoryTestService.addOrderForLaboratoryTest(orderForLaboratoryTest);
    }

    @GetMapping
    public List<OrderForLaboratoryTest> getOrdersForLaboratoryTest() {
        return orderForLaboratoryTestService.getOrdersForLaboratoryTest();
    }

}
