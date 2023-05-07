package ticketapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import ticketapp.model.MovieSession;
import ticketapp.repository.MovieSessionRepository;
import ticketapp.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionRepository movieSessionRepository;

    public MovieSessionServiceImpl(MovieSessionRepository movieSessionRepository) {
        this.movieSessionRepository = movieSessionRepository;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionRepository.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionRepository.add(session);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionRepository.get(id).orElseThrow(()
                -> new NoSuchElementException("Can't get movie session by id " + id));
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        return movieSessionRepository.update(movieSession);
    }

    @Override
    public void delete(Long id) {
        movieSessionRepository.delete(id);
    }
}
