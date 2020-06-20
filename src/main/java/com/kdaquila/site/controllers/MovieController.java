package com.kdaquila.site.controllers;

import com.kdaquila.site.models.Movie;
import com.kdaquila.site.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/create")
    public @ResponseBody String create(@RequestParam String title,
                                            @RequestParam Integer year,
                                            @RequestParam(required = false, defaultValue = "") String description,
                                            @RequestParam(required = false, defaultValue = "") String bestQuote ) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setDescription(description);
        movie.setBestQuote(bestQuote);
        movieRepository.save(movie);
        return "Successfully created: " + title + ", " + year;
    }

    @GetMapping("/readAll")
    public @ResponseBody Iterable<Movie> readAll() {
        return movieRepository.findAll();
    }

}
