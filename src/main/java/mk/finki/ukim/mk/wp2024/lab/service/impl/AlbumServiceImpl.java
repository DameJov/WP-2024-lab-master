package mk.finki.ukim.mk.wp2024.lab.service.impl;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaAlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService
{
    private final JpaAlbumRepository albumRepository;

    public AlbumServiceImpl(JpaAlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(new Album());
    }
}
