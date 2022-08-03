package com.app.iksline.controllers;

import com.app.iksline.entity.UtmEntity;
import com.app.iksline.service.UtmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminAllUtmsController {


  private final UtmService utmService;

  @RequestMapping("/admin/all-utms/{currentPage}")
  public String getAdminPage(Model model, @PathVariable int currentPage) {
    Page<UtmEntity> utms = utmService.getAllUtms(currentPage);

    int totalPage = utms.getTotalPages();
    long totalItems = utms.getTotalElements();
    List<UtmEntity> utmEntities = utms.getContent();


    model.addAttribute("totalPage", totalPage);
    model.addAttribute("totalItems", totalItems);
    model.addAttribute("utmEntities", utmEntities);
    model.addAttribute("currentPage", currentPage);
    return "admin/all";
  }
}
