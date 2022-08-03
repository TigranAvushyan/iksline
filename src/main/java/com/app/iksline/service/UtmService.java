package com.app.iksline.service;

import com.app.iksline.dto.StatisticDto;
import com.app.iksline.entity.UtmEntity;
import com.app.iksline.repository.StatisticRepository;
import com.app.iksline.repository.UtmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UtmService {

  private final UtmRepository utmRepository;
  private final StatisticRepository statisticRepository;

  public void saveUtm(String site, String userAgent) {
    UtmEntity utm = new UtmEntity();

    utm.setSite(site);
    utm.setUserAgent(userAgent);
    utm.setCreatedDate(new Date());

    utmRepository.save(utm);

  }

  public Page<UtmEntity> getAllUtms(int pageNumber) {
    Pageable page = PageRequest.of(pageNumber - 1, 20, Sort.by("createdDate").descending());
    return utmRepository.findAll(page);
  }


  public ArrayList<StatisticDto> getStatisticLastYear() {
    return statisticRepository.findStatisticLastYear();
  }


}
