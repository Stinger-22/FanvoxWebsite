package com.fanvox.db.entitiy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long id;

    private String originalName;
    private String ukrainianName;

    private int year;

    @Column(length = 1027)
    private String description;

    @JsonManagedReference
//    @JsonIgnoreProperties("studios")
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "anime_studio",
            joinColumns = { @JoinColumn(name = "anime_id")},
            inverseJoinColumns = { @JoinColumn(name = "studio_id")})
    private Set<Studio> studios;

    @JsonManagedReference
//@JsonIgnoreProperties("genres")
    @ManyToMany
    @JoinTable(name = "anime_genre",
            joinColumns = { @JoinColumn(name = "anime_id")},
            inverseJoinColumns = { @JoinColumn(name = "genre_id")})
    private Set<Genre> genres = new HashSet<Genre>();

    private String coverImageName;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "anime_id")
    private Set<Episode> episodes;

    public Anime() {

    }

    public Anime(Long id, String originalName, String ukrainianName, int year, String description, Set<Studio> studios, Set<Genre> genres, String coverImageName, Set<Episode> episodes) {
        this.id = id;
        this.originalName = originalName;
        this.ukrainianName = ukrainianName;
        this.year = year;
        this.description = description;
        this.studios = studios;
        this.genres = genres;
        this.coverImageName = coverImageName;
        this.episodes = episodes;
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

    public Set<Studio> getStudios() {
        return studios;
    }

    public void setStudios(Set<Studio> studios) {
        this.studios = studios;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getCoverImageName() {
        return coverImageName;
    }

    public void setCoverImageName(String coverImageName) {
        this.coverImageName = coverImageName;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return year == anime.year && Objects.equals(id, anime.id) && Objects.equals(originalName, anime.originalName) && Objects.equals(ukrainianName, anime.ukrainianName) && Objects.equals(description, anime.description) && Objects.equals(studios, anime.studios) && Objects.equals(genres, anime.genres) && Objects.equals(coverImageName, anime.coverImageName) && Objects.equals(episodes, anime.episodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, ukrainianName, year, description, studios, genres, coverImageName, episodes);
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", ukrainianName='" + ukrainianName + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", studios=" + studios +
                ", genres=" + genres +
                ", coverImageName='" + coverImageName + '\'' +
                ", episodes=" + episodes +
                '}';
    }
}
