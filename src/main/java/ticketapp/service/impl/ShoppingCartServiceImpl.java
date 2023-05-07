package ticketapp.service.impl;

import org.springframework.stereotype.Service;
import ticketapp.model.MovieSession;
import ticketapp.model.ShoppingCart;
import ticketapp.model.Ticket;
import ticketapp.model.User;
import ticketapp.repository.ShoppingCartRepository;
import ticketapp.repository.TicketRepository;
import ticketapp.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final TicketRepository ticketRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   TicketRepository ticketRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ShoppingCart shoppingCart = shoppingCartRepository.getByUser(user);
        ticketRepository.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartRepository.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(null);
        shoppingCartRepository.update(shoppingCart);
    }
}
