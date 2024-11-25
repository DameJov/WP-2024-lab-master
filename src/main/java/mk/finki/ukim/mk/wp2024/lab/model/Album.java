package mk.finki.ukim.mk.wp2024.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    //private List<Song> songs;

    public Album(String genre, String name, String releaseYear) {
        this.genre = genre;
        this.name = name;
        this.releaseYear = releaseYear;
        this.id = (long) (Math.random() * 1000);
        //this.songs = new ArrayList<>();
    }

    public Album() {
        //this.songs = new ArrayList<>();
        this.id = (long) (Math.random() * 1000);
    }
}
