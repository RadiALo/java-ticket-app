package ticketapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ticketapp.model.CinemaHall;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.CinemaHallRepository;

@Repository
public class CinemaHallRepositoryImpl extends AbstractRepository<CinemaHall>
        implements CinemaHallRepository {

    public CinemaHallRepositoryImpl(SessionFactory factory, Class<CinemaHall> clazz) {
        super(factory, clazz);
    }
}
