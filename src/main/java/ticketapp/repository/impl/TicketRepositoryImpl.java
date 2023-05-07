package ticketapp.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ticketapp.model.Ticket;
import ticketapp.repository.AbstractRepository;
import ticketapp.repository.TicketRepository;

@Repository
public class TicketRepositoryImpl extends AbstractRepository<Ticket> implements TicketRepository {
    public TicketRepositoryImpl(SessionFactory factory, Class<Ticket> clazz) {
        super(factory, clazz);
    }
}
