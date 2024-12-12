package mk.finki.ukim.mk.wp2024.lab.repository.jpa;

import mk.finki.ukim.mk.wp2024.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSongRepository extends JpaRepository<Song, Long>
{
    List<Song> findAllByAlbum_Id(Long albumId);
}
