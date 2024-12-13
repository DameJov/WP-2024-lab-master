package mk.finki.ukim.mk.wp2024.lab.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaAlbumRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaArtistRepository;
import mk.finki.ukim.mk.wp2024.lab.repository.jpa.JpaSongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    private final JpaAlbumRepository jpaAlbumRepository;
    private final JpaSongRepository jpaSongRepository;
    private final JpaArtistRepository jpaArtistRepository;

    public DataHolder(JpaAlbumRepository jpaAlbumRepository, JpaSongRepository jpaSongRepository, JpaArtistRepository jpaArtistRepository) {
        this.jpaAlbumRepository = jpaAlbumRepository;
        this.jpaSongRepository = jpaSongRepository;
        this.jpaArtistRepository = jpaArtistRepository;
    }

    @PostConstruct
    public void init()
    {
        artists = new ArrayList<>();
        songs = new ArrayList<>();
        albums = new ArrayList<>();


        artists.add(new Artist("John","Lennon", "Beatles singer"));
        artists.add(new Artist("Kurt","Cobain","Nirvana singer and guitarist"));
        artists.add(new Artist("Paul","McCarney","Beatles singer and bass guitarist"));
        artists.add(new Artist("Lars","Ulrich","Metallica drummer"));
        artists.add(new Artist("James","Hetfield","Metallica lead vocalist and guitarist"));
        artists.add(new Artist("Joakim","Broden","Sabaton lead vocalist and guitarist"));
        jpaArtistRepository.saveAll(artists);

        albums.add(new Album("Heavy metal","Master of Puppets","1986"));
        albums.add(new Album("Heavy metal", "Metallica (Black album)", "1991"));
        albums.add(new Album("Rock","Nevermind","1991"));
        albums.add(new Album("Power Metal","The War to End All Wars","2022"));
        albums.add(new Album("Pop-Rock","Let it Be","1970"));
        jpaAlbumRepository.saveAll(albums);

        songs.add(new Song("Stormtroopers","Power metal",2022, "001", albums.get(3)));
        songs.add(new Song("Let it be","Pop-Rock",1970, "002", albums.get(4)));
        songs.add(new Song("Come as you are", "Rock",1992,"003", albums.get(2)));
        songs.add(new Song("Enter Sandman","Heavy metal", 1991,"004", albums.get(1)));
        songs.add(new Song("Master of Puppets","Heavy metal", 1986,"005", albums.get(0)));
        jpaSongRepository.saveAll(songs);




    }
}
