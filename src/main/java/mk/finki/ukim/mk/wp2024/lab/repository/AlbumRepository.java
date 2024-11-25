package mk.finki.ukim.mk.wp2024.lab.repository;

import mk.finki.ukim.mk.wp2024.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    public List<Album> findAll()
    {
        return DataHolder.albums;
    }
    public Optional<Album> findById(Long id)
    {
        return DataHolder.albums.stream().filter(album -> album.getId().equals(id)).findFirst();
    }
}
