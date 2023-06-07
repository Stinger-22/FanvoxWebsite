package com.fanvox.controller;

import com.fanvox.db.entitiy.Genre;
import com.fanvox.service.GenreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public Iterable<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping("/add")
    public String addNewStudio(@RequestParam String name) {
        return genreService.createGenre(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudio(@PathVariable Long id) {
        return genreService.deleteGenre(id);
    }
}
