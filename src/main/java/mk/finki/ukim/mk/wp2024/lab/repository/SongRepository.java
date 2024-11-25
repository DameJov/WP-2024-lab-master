package mk.finki.ukim.mk.wp2024.lab.repository;

import mk.finki.ukim.mk.wp2024.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> findAll()
    {
        return DataHolder.songs;
    }
    public Optional<Song> findById(String trackId)
    {
        return DataHolder.songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst();
    }
    public Artist addArtistToSong(Song song, Artist artist)
    {
        Song tempSong = findById(song.getTrackId()).orElse(tempSong = new Song());
        tempSong.getPerformers().add(artist);
        return artist;
    }
    public Optional<Song> saveSong(String title, String trackId, String genre, int releaseYear, Album album)
    {
        Song song = new Song(title, genre, releaseYear, trackId, album);
        DataHolder.songs.removeIf(s -> s.getTrackId().equals(song.getTrackId()));
        DataHolder.songs.add(song);
        return Optional.of(song);
    }
    public Optional<Song> findById(Long songId)
    {
        return DataHolder.songs.stream().filter(s -> s.getId().equals(songId)).findFirst();
    }
    public void deleteById(Long songId)
    {
        DataHolder.songs.removeIf(s -> s.getId().equals(songId));
    }


}
