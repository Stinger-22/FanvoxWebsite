package com.fanvox.db.repository;

import com.fanvox.db.entitiy.Anime;
import com.fanvox.db.entitiy.Genre;
import com.fanvox.service.AnimeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
//    @Override
//    List<Anime> findAll();

//    List<Anime> findByGenres();

    Anime getAnimeById(Long id);
    List<Anime> findByFullyDubbedFalse();

//
//    @Query("select a from Anime a where lower(a.originalName) like lower(concat('%', :search, '%')) " +
//            "or lower(a.ukrainianName) like lower(concat('%', :search, '%'))")
//    List<Anime> findByOriginalNameOrUkrainianNameLike(@Param("search") String search);
}
