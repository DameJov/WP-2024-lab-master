package mk.finki.ukim.mk.wp2024.lab.repository.jpa;

import mk.finki.ukim.mk.wp2024.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp2024.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaAlbumRepository extends JpaRepository<Album, Long> {
}
