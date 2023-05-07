package ticketapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ticketapp.model.Movie;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl extends AbstractRepository<Movie>
        implements MovieRepository {
    public MovieRepositoryImpl(SessionFactory factory, Class<Movie> clazz) {
        super(factory, clazz);
    }
}
