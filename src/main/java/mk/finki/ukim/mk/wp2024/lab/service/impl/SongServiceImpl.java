package mk.finki.ukim.mk.wp2024.lab.service.impl;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.SongRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaAlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaSongRepository;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final JpaSongRepository songRepository;
    private final JpaAlbumRepository albumRepository;

    public SongServiceImpl(JpaSongRepository songRepository, JpaAlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        songRepository.save(song); // Save the updated song
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId)
                .orElseThrow(() -> new RuntimeException("Song with trackId " + trackId + " not found"));
    }

    @Override
    public Optional<Song> save(String title, String trackId, String genre, int releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album with id " + albumId + " not found"));
        Song song = new Song(title, genre, releaseYear, trackId, album);
        return Optional.of(songRepository.save(song));
    }

    @Override
    public Optional<Song> update(Long id, String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song with id " + id + " not found"));

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album with id " + albumId + " not found"));

        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);

        return Optional.of(songRepository.save(song));
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song with id " + id + " not found"));
    }
}
