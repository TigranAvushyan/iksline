package com.app.iksline.repository;

import com.app.iksline.entity.UtmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtmRepository extends JpaRepository<UtmEntity, Long> {

}
