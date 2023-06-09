package com.fanvox.db.entitiy;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Long id;

    private String episodeName;
    private int episodeNumber;
    private Long anime_id;

    public Episode() {

    }

    public Episode(Long id, String episodeName, int episodeNumber, Long anime_id) {
        this.id = id;
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.anime_id = anime_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return episodeNumber == episode.episodeNumber && Objects.equals(id, episode.id) && Objects.equals(episodeName, episode.episodeName) && Objects.equals(anime_id, episode.anime_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, episodeName, episodeNumber, anime_id);
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", episodeName='" + episodeName + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", anime_id=" + anime_id +
                '}';
    }
}
