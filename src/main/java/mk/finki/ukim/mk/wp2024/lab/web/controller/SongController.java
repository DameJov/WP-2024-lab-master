package mk.finki.ukim.mk.wp2024.lab.web.controller;

import mk.finki.ukim.mk.wp2024.lab.model.Album;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.service.AlbumService;
import org.springframework.ui.Model;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/songs")
public class SongController
{
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping()
    public String getSongsPage(@RequestParam(required = false) String error, Model model)
    {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("songs", this.songService.listSongs());
        return "listSongs";
    }
    @GetMapping("/add-form")
    public String addSongPage(Model model) {
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("albums", albums);
        return "add-song";
    }
    @GetMapping("/edit-form/{id}")
    public String editSong(@PathVariable Long id, Model model) {
            Song song = this.songService.findById(id);
            List<Album> albums = this.albumService.findAll();
            model.addAttribute("albums", albums);
            model.addAttribute("song", song);
            return "add-song";
    }
    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId)
    {
        songService.save(title,trackId,genre,releaseYear,albumId);
        return "redirect:/songs";
    }
    @PostMapping("/edit/{songId}" )
    public String editSong(@PathVariable Long songId,
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId)
    {
        songService.update(songId,title, trackId,genre,releaseYear,albumId);
        return "redirect:/songs";
    }
    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id)
    {
        this.songService.delete(id);
        return "redirect:/songs";
    }
    @GetMapping("/details/{id}")
    public String getSongDetails(@PathVariable String id, Model model)
    {

        Song song = songService.findByTrackId(id);
        model.addAttribute("name",song.getTitle());
        model.addAttribute("genre",song.getGenre());
        model.addAttribute("year",song.getReleaseYear());
        model.addAttribute("artists", song.getPerformers());

        return "songDetails";
    }
}
