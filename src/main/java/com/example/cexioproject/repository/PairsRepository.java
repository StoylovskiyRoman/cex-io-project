package com.example.cexioproject.repository;

import com.example.cexioproject.entities.PairEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PairsRepository extends JpaRepository <PairEntity, Long> {

   List<PairEntity> findBySymbol1OrderByMinPriceAsc(String currencyName);

   List<PairEntity> findBySymbol1OrderByMaxPriceDesc(String currencyName);

   List<PairEntity> findBySymbol1(String currencyName, Pageable pageable);

}