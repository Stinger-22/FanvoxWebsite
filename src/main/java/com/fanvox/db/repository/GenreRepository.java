package com.fanvox.db.repository;

import com.fanvox.db.entitiy.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository <Genre, Long> {

}
