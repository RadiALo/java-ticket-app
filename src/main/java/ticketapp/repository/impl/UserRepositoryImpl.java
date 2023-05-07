package ticketapp.repository.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ticketapp.exception.DataProcessingException;
import ticketapp.model.User;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    public UserRepositoryImpl(SessionFactory factory, Class<User> clazz) {
        super(factory, clazz);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = factory.openSession()) {
            Query<User> findByEmail = session.createQuery(
                    "FROM User u "
                            + "JOIN FETCH u.roles "
                            + "WHERE email = :email", User.class);
            findByEmail.setParameter("email", email);
            return findByEmail.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get User by email " + email, e);
        }
    }
}
