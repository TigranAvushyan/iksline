package com.app.iksline.repository;

import com.app.iksline.dto.StatisticDto;
import com.app.iksline.entity.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {

  @Query(name = "statistic_year", nativeQuery = true)
  ArrayList<StatisticDto> findStatisticLastYear();

}
