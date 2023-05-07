package ticketapp.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ticketapp.exception.DataProcessingException;
import ticketapp.model.ShoppingCart;
import ticketapp.model.User;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.ShoppingCartRepository;

@Repository
public class ShoppingCartRepositoryImpl extends AbstractRepository<ShoppingCart>
        implements ShoppingCartRepository {
    public ShoppingCartRepositoryImpl(SessionFactory factory, Class<ShoppingCart> clazz) {
        super(factory, clazz);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> getByUser = session.createQuery(
                    "SELECT DISTINCT sc FROM ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.movieSession ms "
                            + "left join fetch ms.cinemaHall "
                            + "left join fetch ms.movie "
                            + "WHERE sc.user = :user", ShoppingCart.class);
            getByUser.setParameter("user", user);
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Shopping cart by user " + user, e);
        }
    }
}
