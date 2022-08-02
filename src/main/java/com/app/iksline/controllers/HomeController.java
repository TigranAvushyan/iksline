package com.app.iksline.controllers;

import com.app.iksline.service.UtmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

  private final UtmService utmService;

  @RequestMapping("/")
  public String homePage(@RequestParam(name = "utm", required = false) String utm, HttpServletRequest request) {
    if (utm != null) {
      String userAgent = request.getHeader("User-Agent");
      log.info("Site: {}, User Agent: {}", utm, userAgent);
      utmService.saveUtm(utm, userAgent);
    }
    return "index";
  }
}
