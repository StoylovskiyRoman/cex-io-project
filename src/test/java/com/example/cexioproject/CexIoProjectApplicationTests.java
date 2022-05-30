package com.example.cexioproject;

import com.example.cexioproject.dto.Pair;
import com.example.cexioproject.dto.Root;
import com.example.cexioproject.entities.PairEntity;
import com.example.cexioproject.repository.PairsRepository;
import com.example.cexioproject.service.CexExternalService;
import com.example.cexioproject.service.CexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CexIoProjectApplicationTests {

    @Autowired
    private CexExternalService cexExternalService;
    @Autowired
    private CexService cexService;

    @Autowired
    private PairsRepository pairsRepository;
    private String currencyName;

    @Test
    void contextLoads() throws JsonProcessingException {
        // Given
        //When
        Root allData = cexExternalService.getAllData();

        //List<Pair> allData = cexService.getAllData();
        //List<PairEntity> all = pairsRepository.findBySymbol1OrderByMinPriceAsc(currencyName);
        //Then
        assertNotNull(allData);
        assertEquals("ok", allData.getStatus());
        assertEquals("currency_limits", allData.getEndPoint());

    }

}
