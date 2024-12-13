package mk.finki.ukim.mk.wp2024.lab.repository.jpa;

import mk.finki.ukim.mk.wp2024.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaSongRepository extends JpaRepository<Song, Long>
{

    @Query("SELECT s FROM Song s WHERE s.trackId = :trackId")
    Optional<Song> findByTrackId(@Param("trackId") String trackId);

    @Query("SELECT s FROM Song s WHERE s.album.id = :albumId")
    List<Song> findAllByAlbum_Id(@Param("albumId") Long albumId);

}
