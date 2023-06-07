package com.fanvox.db.entitiy;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalName;
    private String englishName;
    private String ukrainianName;

    private int year;
    private String description;

    @ManyToMany
    private Set<Genre> genres;

    public Anime() {

    }

    public Anime(Long id, String originalName, String englishName, String ukrainianName, int year, String description, Set<Genre> genres) {
        this.id = id;
        this.originalName = originalName;
        this.englishName = englishName;
        this.ukrainianName = ukrainianName;
        this.year = year;
        this.description = description;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getUkrainianName() {
        return ukrainianName;
    }

    public void setUkrainianName(String ukrainianName) {
        this.ukrainianName = ukrainianName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return year == anime.year && Objects.equals(id, anime.id) && Objects.equals(originalName, anime.originalName) && Objects.equals(englishName, anime.englishName) && Objects.equals(ukrainianName, anime.ukrainianName) && Objects.equals(description, anime.description) && Objects.equals(genres, anime.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, englishName, ukrainianName, year, description, genres);
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", ukrainianName='" + ukrainianName + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", genres=" + genres +
                '}';
    }
}
