package ticketapp.repository;

import ticketapp.model.Ticket;

public interface TicketRepository {
    Ticket add(Ticket ticket);
}
