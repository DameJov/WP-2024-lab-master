package mk.finki.ukim.mk.wp2024.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.wp2024.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet
{
    private final SongService songService;
    private final SpringTemplateEngine templateEngine;

    public SongDetailsServlet(SongService songService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String trackId = req.getParameter("trackId");
        context.setVariable("name",songService.findByTrackId(trackId).getTitle());
        context.setVariable("genre",songService.findByTrackId(trackId).getGenre());
        context.setVariable("year",songService.findByTrackId(trackId).getReleaseYear());

        context.setVariable("artists",songService.findByTrackId(trackId).getPerformers());

        templateEngine.process("songDetails.html", context, resp.getWriter());
    }

}
