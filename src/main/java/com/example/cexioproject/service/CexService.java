package com.example.cexioproject.service;


import com.example.cexioproject.dto.Pair;
import com.example.cexioproject.dto.Root;
import com.example.cexioproject.entities.PairEntity;
import com.example.cexioproject.repository.PairsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CexService {

    private PairsRepository pairsRepository;
    private CexExternalService cexExternalService;
    private ModelMapper modelMapper;

    public CexService(PairsRepository pairsRepository, CexExternalService cexExternalService,
                      ModelMapper modelMapper) {
        this.pairsRepository = pairsRepository;
        this.cexExternalService = cexExternalService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        //pairsRepository.deleteAll();
        Root allData = this.cexExternalService.getAllData();
        List<PairEntity> pairEntities = modelMapper.map(allData.getData().getPairs(), new TypeToken<List<PairEntity>>() {
        }.getType());
        pairsRepository.saveAll(pairEntities);
    }
    public List<Pair> getAllData(){
        List<PairEntity> all = pairsRepository.findAll();
        return  modelMapper.map(all, new TypeToken<List<Pair>>() {}.getType());
    }
    /**
     * Return List of Data sorted by asc
     * @param currencyName
     * @return
     */

    public List<Pair> getMinPairs(String currencyName) {
        List<PairEntity> all = pairsRepository.findBySymbol1OrderByMinPriceAsc(currencyName);
        return modelMapper.map(all, new TypeToken<List<Pair>>() {
        }.getType());
    }

    /**
     * Return List of Data sorted by desc
     * @param currencyName
     * @return
     */

    public List<Pair> getMaxPairs(String currencyName) {
        List<PairEntity> all = pairsRepository.findBySymbol1OrderByMaxPriceDesc(currencyName);
        return modelMapper.map(all, new TypeToken<List<Pair>>() {
        }.getType());
    }
    /**
     * Return record with min price
     * @param currencyName
     * @return
     */

    public Pair getMinPair(String currencyName) {
        PairEntity pairEntity = pairsRepository.findFirstBySymbol1OrderByMinPriceAsc(currencyName);
        return modelMapper.map(pairEntity, Pair.class);
    }

    /**
     * Return record with max price
     * @param currencyName
     * @return
     */

    public Pair getMaxPair(String currencyName) {
        PairEntity pairEntity = pairsRepository.findFirstBySymbol1OrderByMaxPriceDesc(currencyName);
        return modelMapper.map(pairEntity, Pair.class);
    }


    public List<Pair> getAllDataWithPaging (String currencyName, int page, int size) throws JsonProcessingException {
        List<PairEntity> all = pairsRepository.findBySymbol1(currencyName, PageRequest.of(page, size));
        ObjectMapper objectMapper = new ObjectMapper().configure
                (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String json = objectMapper.writeValueAsString(all);
        return objectMapper.readValue(json, new TypeReference<List<Pair>>() {
        });
    }



}
