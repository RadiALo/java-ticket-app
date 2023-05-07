package ticketapp.repository;

import java.util.List;
import java.util.Optional;
import ticketapp.model.CinemaHall;

public interface CinemaHallRepository {
    CinemaHall add(CinemaHall cinemaHall);

    Optional<CinemaHall> get(Long id);

    List<CinemaHall> getAll();
}
