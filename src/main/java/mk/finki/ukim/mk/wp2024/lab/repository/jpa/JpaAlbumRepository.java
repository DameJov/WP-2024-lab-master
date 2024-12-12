package mk.finki.ukim.mk.wp2024.lab.repository.jpa;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAlbumRepository extends JpaRepository<Album, Long> {

}
