package com.example.cexioproject;

import com.example.cexioproject.dto.Pair;
import com.example.cexioproject.dto.Root;
import com.example.cexioproject.repository.PairsRepository;
import com.example.cexioproject.service.CexExternalService;
import com.example.cexioproject.service.CexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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

        //Then
        assertNotNull(allData);
        assertEquals("ok", allData.getStatus());
        assertEquals("currency_limits", allData.getEndPoint());

    }
    @Test
    void getMinPriceV1()  {
        // Given
        //When
        List<Pair> allData = cexService.getMinPairs("BTC");

        //Then
        assertNotNull(allData);
        assertEquals("2000",allData.get(0).getMinPrice());

    }
    // optimize
    @Test
    void getMinPriceV2()  {
        // Given
        //When
        Pair minPair= cexService.getMinPair("BTC");

        //Then
        assertNotNull(minPair);
        assertEquals("2000", minPair.getMinPrice());

    }
    @Test
    void getMaxPriceV1()  {
        // Given
        //When
        List<Pair> allData = cexService.getMaxPairs("BTC");

        //Then
        assertNotNull(allData);
        assertEquals("350000",allData.get(0).getMaxPrice());

    }
    // optimize
    @Test
    void getMaxPriceV2()  {
        // Given
        //When
        Pair maxPair= cexService.getMaxPair("BTC");

        //Then
        assertNotNull(maxPair);
        assertEquals("350000", maxPair.getMaxPrice());

    }


}
