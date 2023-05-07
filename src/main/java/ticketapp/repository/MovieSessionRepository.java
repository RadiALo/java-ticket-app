package ticketapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import ticketapp.model.MovieSession;

public interface MovieSessionRepository {
    MovieSession add(MovieSession movieSession);

    Optional<MovieSession> get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);
}
