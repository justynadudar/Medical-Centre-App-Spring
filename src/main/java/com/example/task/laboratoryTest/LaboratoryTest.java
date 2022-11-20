package com.example.task.laboratoryTest;

import com.example.task.orderForLaboratoryTest.OrderForLaboratoryTest;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class LaboratoryTest {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_for_laboratory_test_id", referencedColumnName = "id")
    private OrderForLaboratoryTest orderForLaboratoryTest;

    private byte[] testFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderForLaboratoryTest getOrderForLaboratoryTest() {
        return orderForLaboratoryTest;
    }

    public void setOrderForLaboratoryTest(OrderForLaboratoryTest orderForLaboratoryTest) {
        this.orderForLaboratoryTest = orderForLaboratoryTest;
    }

    public byte[] getTestFile() {
        return testFile;
    }

    public void setTestFile(byte[] testFile) {
        this.testFile = testFile;
    }


    @Override
    public String toString() {
        return "LaboratoryTest{" +
                "id=" + id +
                ", orderForLaboratoryTest=" + orderForLaboratoryTest +
                ", testFile=" + Arrays.toString(testFile) +
                '}';
    }
}
