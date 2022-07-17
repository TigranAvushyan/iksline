package com.app.iksline.utm;

import com.app.iksline.entity.UtmEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UtmService {

  private final UtmRepository utmRepository;

  public void saveUtm(String site, String userAgent) {
    UtmEntity utm = new UtmEntity();

    utm.setSite(site);
    utm.setUserAgent(userAgent);
    utm.setCreatedDate(new Date());

    utmRepository.save(utm);

  }

}
