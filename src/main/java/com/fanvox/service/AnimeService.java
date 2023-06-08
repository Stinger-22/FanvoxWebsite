package com.fanvox.service;

import com.fanvox.db.entitiy.Anime;
import com.fanvox.db.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Iterable<Anime> getAll() {
        return animeRepository.findAll();
    }

    public Optional<Anime> getByAnimeId(Long id) {
        return animeRepository.findById(id);
    }
}
