package com.app.iksline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalControllers {

  @RequestMapping("/rzd")
  public String getRzdPage() {
    return "rzd";
  }

  @RequestMapping("/video")
  public String getVideoPage() {
    return "video";
  }

  @RequestMapping("/energy")
  public String getEnergyPage() {
    return "energy";
  }
  @RequestMapping("/contact")
  public String getContactPage() {
    return "contact";
  }
  @RequestMapping("/about")
  public String getAboutPage() {
    return "about";
  }
}
