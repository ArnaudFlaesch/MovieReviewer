package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.utils.MovieUtils;
import com.esgi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private String apiAllocineUrl = "http://api.allocine.fr/rest/v3/search?count=500&filter=movie&format=json&page=1&partner=YW5kcm9pZC12Mg&profile=medium&q=";

    @Autowired
    private MovieService movieService;

    /**
     * Affiche le détail d'un film
     * @param idMovie
     * @param model
     * @return
     */
    @RequestMapping(method= RequestMethod.GET)
    public String displayMovie(@RequestParam Long idMovie, Model model) {
        model.addAttribute("movieUtils", new MovieUtils());
        MovieEntity movie = new MovieEntity();
        model.addAttribute("movie", movie);
        model.addAttribute("movie", movieService.getDetailMovie(idMovie));
        return("movies");
    }

    /**
     * Affiche la page pour ajouter un film
     * @param model
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addToMovieList(Model model) {
        model.addAttribute("movie", new MovieEntity());
        return ("addMovie");
    }

    /**
     * Ajoute un film à la base de données
     * @param movie
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addMovie(@ModelAttribute MovieEntity movie, Model model) {
        model.addAttribute("movieUtils", new MovieUtils());
        movieService.addMovie(movie);
        return("index");
    }

    /**
     * Recherche les
     * @param movieUtils
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchMoviesFromBDD(@ModelAttribute MovieUtils movieUtils, Model model) {
        if (!movieUtils.getResearch().equals("")) {
            model.addAttribute("listMovies", movieService.searchMovies(movieUtils.getResearch()));
        }
        return ("movies");
    }

    /*
    @RequestMapping(value = "/search/API", method = RequestMethod.POST)
    public String searchMoviesFromApi(@ModelAttribute MovieUtils movieUtils, Model model) {
        if (!movieUtils.getSearchContent().equals("")) {
            try {
                InputStream is = new URL(apiAllocineUrl+movieUtils.getSearchContent()).openStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                JsonObject body = Json.createReader(new StringReader(parseJsonFromReader(rd))).readObject();
                ArrayList<MovieEntity> listMovies = parseJsonMovieList(body.getJsonObject("feed").getJsonArray("movie"));
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


    private ArrayList<MovieEntity> parseJsonMovieList(JsonArray listMovieFromApi) {
        ArrayList<MovieEntity> listMovies = new ArrayList();
        for (int i = 0; i<listMovieFromApi.size(); i++) {
            JsonObject movieJson = listMovieFromApi.getJsonObject(i);
            MovieEntity movie = new MovieEntity();
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