package mk.finki.ukim.mk.wp2024.lab.repository.jpa;

import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaArtistRepository extends JpaRepository<Artist, Long> {
}
