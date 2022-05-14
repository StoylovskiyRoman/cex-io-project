package com.example.cexioproject;

import com.example.cexioproject.dto.Root;
import com.example.cexioproject.service.CexExternalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CexIoProjectApplicationTests {

    @Autowired
    private CexExternalService cexExternalService;
    @Test
    void contextLoads() throws JsonProcessingException {
        // Given
        //When
        Root allData = cexExternalService.getAllData();
        //Then
        assertNotNull(allData);
        assertEquals("ok", allData.getStatus());
        assertEquals("currency_limits", allData.getEndPoint());

    }

}
