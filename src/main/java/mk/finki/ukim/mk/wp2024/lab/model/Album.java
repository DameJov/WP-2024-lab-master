package mk.finki.ukim.mk.wp2024.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();

    public Album(String genre, String name, String releaseYear) {
        this.genre = genre;
        this.name = name;
        this.releaseYear = releaseYear;
        //this.id = (long) (Math.random() * 1000);
    }
    public Album() {}
}
