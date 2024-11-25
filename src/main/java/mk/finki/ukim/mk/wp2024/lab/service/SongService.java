package mk.finki.ukim.mk.wp2024.lab.service;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    Optional<Song> save(String title, String trackId, String genre, int releaseYear, Long albumId);
    Optional<Song> update(Long id, String title, String trackId, String genre, int releaseYear, Long albumId);
    void delete(Long id);
    Song findById(Long id);

}
