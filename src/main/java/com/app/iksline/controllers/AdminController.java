package com.app.iksline.controllers;


import com.app.iksline.dto.StatisticDto;
import com.app.iksline.service.UtmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {


  private final UtmService utmService;

  @RequestMapping("/admin")
  public String getAdminPage(Model model) {
    ArrayList<StatisticDto> statisticLastYear = utmService.getStatisticLastYear();

    model.addAttribute("statisticList", statisticLastYear);
    return "admin/index";
  }

}
