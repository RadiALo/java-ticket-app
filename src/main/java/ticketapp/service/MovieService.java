package ticketapp.service;

import java.util.List;
import ticketapp.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
