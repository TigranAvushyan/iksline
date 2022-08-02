package com.app.iksline.entity;

import com.app.iksline.dto.StatisticDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(
    name = "statistic_year",
    query = "SELECT count(id) as total, site, date_trunc('month', created_date) as created_month from utm where created_date > now()  - interval '1' year group by created_month, site order by created_month",
    resultSetMapping = "statistic_dto"
)
@SqlResultSetMapping(
    name = "statistic_dto",
    classes = @ConstructorResult(
        targetClass = StatisticDto.class,
        columns = {
            @ColumnResult(name = "total", type = Integer.class),
            @ColumnResult(name = "site", type = String.class),
            @ColumnResult(name = "created_month", type = Date.class)
        }
    )
)
public class StatisticEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
