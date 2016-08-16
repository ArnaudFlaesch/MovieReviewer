package com.esgi.controllers;

import com.esgi.model.*;
import com.esgi.utils.SearchUtils;
import com.esgi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private String apiAllocineUrl = "http://api.allocine.fr/rest/v3/search?count=500&filter=movie&format=json&page=1&partner=YW5kcm9pZC12Mg&profile=medium&q=";

    @Autowired
    private MovieService movieService;

    /**
     * Affiche le détail d'un film
     * @param movie
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String displayMovie(@ModelAttribute Movie movie, Model model) {
        model.addAttribute("searchUtils", new SearchUtils());
        movie = movieService.getDetailMovie(movie.getIdmovie());
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        BigDecimal rating = new BigDecimal(0.0);
        Long iduser = SessionUser.getIduser();
        boolean hasReviewed = false;
        if (movie.getListReviews().size() > 0) {
            for (Review review : movie.getListReviews()) {
                rating = rating.add(review.getRating());
                if (review.getIduser().equals(iduser)) {
                    hasReviewed = true;
                }
            }
            movie.setNote(rating.divide(new BigDecimal(movie.getListReviews().size())));
        }
        model.addAttribute("hasReviewed", !hasReviewed);
        model.addAttribute("movie", movie);
        model.addAttribute("comment", new Comment());
        model.addAttribute("review", new Review());
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        return("detailMovie");
    }

    /**
     * Affiche la page pour ajouter un film
     * @param model
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("searchUtils", new SearchUtils());
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        return ("addMovie");
    }

    /**
     * Ajoute un film à la base de données
     * @param movie
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addMovie(@ModelAttribute Movie movie, Model model) {
        movieService.addMovie(movie);
        model.addAttribute("searchUtils", new SearchUtils());
        List<Movie> listMovies = movieService.getLastMovies();
        for (Movie film : listMovies) {
            BigDecimal rating = new BigDecimal(0.0);
            if (film.getListReviews() != null && film.getListReviews().size() > 0) {
                for (Review review : film.getListReviews()) {
                    rating = rating.add(review.getRating());
                }
                film.setNote(rating.divide(new BigDecimal(film.getListReviews().size())));
            }
        }
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        model.addAttribute("listMovies", listMovies);
        return("index");
    }

    /**
     * Recherche les
     * @param searchUtils
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchMoviesFromBDD(@ModelAttribute SearchUtils searchUtils, Model model) {
        if (!searchUtils.getResearch().equals("")) {
            List<Movie> listMovies = movieService.searchMovies(searchUtils.getResearch());
            model.addAttribute("listMovies", listMovies);
            model.addAttribute("movie", new Movie());
            model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        }
        return ("movies");
    }

    /*
    @RequestMapping(value = "/search/API", method = RequestMethod.POST)
    public String searchMoviesFromApi(@ModelAttribute SearchUtils searchUtils, Model model) {
        if (!movieUtils.getSearchContent().equals("")) {
            try {
                InputStream is = new URL(apiAllocineUrl+movieUtils.getSearchContent()).openStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                JsonObject body = Json.createReader(new StringReader(parseJsonFromReader(rd))).readObject();
                ArrayList<Movie> listMovies = parseJsonMovieList(body.getJsonObject("feed").getJsonArray("movie"));
                model.addAttribute("listMovies", listMovies);
            }
            catch (IOException error) {
                System.out.println(error);
            }
        }
        return ("movies");
    }

    private String parseJsonFromReader(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    private ArrayList<Movie> parseJsonMovieList(JsonArray listMovieFromApi) {
        ArrayList<Movie> listMovies = new ArrayList();
        for (int i = 0; i<listMovieFromApi.size(); i++) {
            JsonObject movieJson = listMovieFromApi.getJsonObject(i);
            Movie movie = new Movie();
            movie.setTitle(movieJson.getString("originalTitle"));
            if (movieJson.get("poster") != null) {
                movie.setImageUrl(((JsonObject)movieJson.get("poster")).getString("href"));
            }
            //movie.setDate_release(new Date(((JsonObject)movieJson.get("release")).getString("releaseDate")));
            movie.setCodeAllocine(movieJson.getJsonNumber("code").intValue());
            if (movieJson.get("statistics") != null) {
                movie.setNoteAllocine(((JsonObject)movieJson.get("statistics")).getJsonNumber("userRating").bigDecimalValue().setScale(2, BigDecimal.ROUND_FLOOR).floatValue());
            }
            listMovies.add(movie);
        }
        return (listMovies);
    }*/
}