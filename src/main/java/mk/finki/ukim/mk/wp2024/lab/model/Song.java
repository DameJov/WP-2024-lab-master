package mk.finki.ukim.mk.wp2024.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Album album;

    public Song(String title, String genre, int releaseYear, String trackId, Album album)
    {
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.title = title;
        this.trackId = trackId;
        this.performers = new ArrayList<>();
        this.album = album;
    }

    public Song() {
        this.performers = new ArrayList<>();
        this.album = new Album();
    }
}
