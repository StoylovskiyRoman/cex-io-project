package com.example.cexioproject.controller;

import com.example.cexioproject.dto.Pair;
import com.example.cexioproject.service.CexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CexController {

    private CexService cexService;

    public CexController(CexService cexService) {
        this.cexService = cexService;
    }

    @GetMapping("/all")
    public List<Pair> getAll(){
        return this.cexService.getAllData();
    }

    @GetMapping("/minprice")
    public Pair getMinPair (@RequestParam ("name") String currencyName){
        return this.cexService.getMinPair(currencyName).get(0);
    }
    @GetMapping("/maxprice")
    public Pair getMaxPairs (@RequestParam ("name") String currencyName){
        return this.cexService.getMaxPairs(currencyName).get(0);
    }

    @GetMapping("/")
    public List<Pair> getAllDataWithPaging (@RequestParam ("name") String currencyName, @RequestParam ("page")
    int page, @RequestParam ("size") int size) throws JsonProcessingException {
        return this.cexService.getAllDataWithPaging (currencyName, page, size);
    }
}
