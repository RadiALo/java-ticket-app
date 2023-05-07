package ticketapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import ticketapp.model.CinemaHall;
import ticketapp.repository.CinemaHallRepository;
import ticketapp.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallRepository.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallRepository.get(id).orElseThrow(()
                -> new NoSuchElementException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallRepository.getAll();
    }
}
