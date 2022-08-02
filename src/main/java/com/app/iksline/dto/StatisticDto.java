package com.app.iksline.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StatisticDto {
  private int total;
  private String site;
  private Date created_month;

  public StatisticDto(int count, String site, Date created_month) {
    this.total = count;
    this.site = site;
    this.created_month = created_month;
  }

}
