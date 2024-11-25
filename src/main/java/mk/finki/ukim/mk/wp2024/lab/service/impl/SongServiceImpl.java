package mk.finki.ukim.mk.wp2024.lab.service.impl;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.SongRepository;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService
{
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(song, artist);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findById(trackId).orElse(new Song());
    }

    @Override
    public Optional<Song> save(String title, String trackId, String genre, int releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId).orElse(new Album());
        return this.songRepository.saveSong(title, trackId, genre, releaseYear, album);
    }

    @Override
    public Optional<Song> update(Long id, String title, String trackId, String genre, int releaseYear, Long albumId)
    {
        Song song = songRepository.findById(id).orElse(new Song());
        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumRepository.findById(albumId).orElse(new Album()));
        return Optional.of(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
    @Override
    public Song findById(Long id)
    {
        return songRepository.findById(id).orElse(new Song());
    }
}
