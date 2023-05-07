package ticketapp.repository.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ticketapp.exception.DataProcessingException;
import ticketapp.model.MovieSession;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.MovieSessionRepository;

@Repository
public class MovieSessionRepositoryImpl extends AbstractRepository<MovieSession>
        implements MovieSessionRepository {
    public MovieSessionRepositoryImpl(SessionFactory factory, Class<MovieSession> clazz) {
        super(factory, clazz);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<MovieSession> getAvailableSessions = session.createQuery(
                    "FROM MovieSession m WHERE m.movie.id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", MovieSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Movie sessions not founded by id "
                    + movieId + " and show date " + date, e);
        }
    }
}
