package com.fanvox.db.repository;

import com.fanvox.db.entitiy.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository <Studio, Long> {
    Studio findByName(String name);
}
