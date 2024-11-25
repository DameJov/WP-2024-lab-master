package mk.finki.ukim.mk.wp2024.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.wp2024.lab.model.Artist;
import mk.finki.ukim.mk.wp2024.lab.model.Song;
import mk.finki.ukim.mk.wp2024.lab.service.ArtistService;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet
{
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public ArtistServlet(SongService songService, ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("artists",artistService.listArtists());
        String trackId = req.getParameter("trackId");
        context.setVariable("trackId",trackId);

        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistsId = req.getParameter("artist");
        Artist artist = artistService.findById(Long.parseLong(artistsId));
        Song song = songService.findByTrackId(req.getParameter("track"));
        songService.addArtistToSong(artist,song);
        resp.sendRedirect("/songDetails?trackId="+req.getParameter("track"));
    }
}
