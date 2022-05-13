package com.example.cexioproject;

import com.example.cexioproject.service.CexExternalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CexIoProjectApplicationTests {

    @Autowired
    private CexExternalService cexExternalService;
    @Test
    void contextLoads() {
        // Given
        //When
        String allData = cexExternalService.getAllData();
        //Then
        assertNotNull(allData);
    }

}
