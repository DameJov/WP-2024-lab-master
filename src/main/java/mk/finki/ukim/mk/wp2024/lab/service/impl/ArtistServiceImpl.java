package mk.finki.ukim.mk.wp2024.lab.service.impl;

import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaArtistRepository;
import mk.finki.ukim.mk.wp2024.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService
{
    private final JpaArtistRepository artistRepository;

    public ArtistServiceImpl(JpaArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(new Artist());
    }
}
