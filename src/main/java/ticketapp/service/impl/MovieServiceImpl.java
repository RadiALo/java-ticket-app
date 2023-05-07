package ticketapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import ticketapp.model.Movie;
import ticketapp.repository.MovieRepository;
import ticketapp.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie add(Movie movie) {
        return movieRepository.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieRepository.get(id).orElseThrow(()
                -> new NoSuchElementException("Can't get movie by id " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }
}
