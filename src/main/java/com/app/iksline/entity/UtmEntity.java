package com.app.iksline.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utm")
@Data
public class UtmEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_agent")
  private String userAgent;

  @Column(name = "created_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Column(name = "site")
  private String site;


}
