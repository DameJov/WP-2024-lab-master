package mk.finki.ukim.mk.wp2024.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.service.ArtistService;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }


    @GetMapping("/{trackId}")
    public String getArtistsPage(@PathVariable String trackId, Model model)
    {
        model.addAttribute("trackId",trackId);
        model.addAttribute("artists",this.artistService.listArtists());
        return "artistsList";
    }
    @PostMapping("/add-artist/{trackId}")
    public String addArtistToSong(@PathVariable String trackId, @RequestParam Long artistId)
    {
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.findById(artistId);
        songService.addArtistToSong(artist,song);
        return "redirect:/songs/details/" + trackId;
    }

}
