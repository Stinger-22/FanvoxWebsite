package com.fanvox.service;

import com.fanvox.db.entitiy.Genre;
import com.fanvox.db.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public String createGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        genreRepository.save(genre);
        return "Genre created";
    }

    public Iterable<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public String deleteGenre(Long id) {
        genreRepository.deleteById(id);
        return "Genre is deleted";
    }
}
