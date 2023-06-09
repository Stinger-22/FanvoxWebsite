package com.fanvox.controller;

import com.fanvox.db.entitiy.Anime;
import com.fanvox.service.AnimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/anime")
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/all")
    public Iterable<Anime> getAll() {
        return animeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Anime> getAnimeById(@PathVariable Long id) {
        return animeService.getByAnimeId(id);
    }

    @GetMapping("/dubbing")
    public Iterable<Anime> getDubbing() {
        return animeService.getDubbing();
    }
}
