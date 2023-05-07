package ticketapp.repository;

import java.util.List;
import java.util.Optional;
import ticketapp.model.Movie;

public interface MovieRepository {
    Movie add(Movie movie);

    Optional<Movie> get(Long id);

    List<Movie> getAll();
}
