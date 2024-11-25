package mk.finki.ukim.mk.wp2024.lab.service;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();
    Album findById(Long id);
}
