package com.app.iksline.utm;

import com.app.iksline.entity.UtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtmRepository extends JpaRepository<UtmEntity, Long> {

}
