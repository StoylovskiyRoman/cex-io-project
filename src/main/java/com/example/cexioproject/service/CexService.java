package com.example.cexioproject.service;


import com.example.cexioproject.dto.Root;
import com.example.cexioproject.entities.PairEntity;
import com.example.cexioproject.repository.PairsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        pairsRepository.deleteAll();
        Root allData = this.cexExternalService.getAllData();
        List<PairEntity> pairEntities = modelMapper.map(allData.getData().getPairs(), new TypeToken<List<PairEntity>>() {
        }.getType());
        pairsRepository.saveAll(pairEntities);

    }

}
