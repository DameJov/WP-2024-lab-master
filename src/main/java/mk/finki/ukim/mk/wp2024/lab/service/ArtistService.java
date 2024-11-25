package mk.finki.ukim.mk.wp2024.lab.service;

import mk.finki.ukim.mk.wp2024.lab.model.Artist;

import java.util.List;

public interface ArtistService{
    List<Artist> listArtists();
    Artist findById(Long id);
}
