package com.example.cexioproject.repository;

import com.example.cexioproject.entities.PairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairsRepository extends JpaRepository <PairEntity, Long> {

}
