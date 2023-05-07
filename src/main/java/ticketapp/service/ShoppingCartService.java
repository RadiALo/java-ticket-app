package ticketapp.service;

import ticketapp.model.MovieSession;
import ticketapp.model.ShoppingCart;
import ticketapp.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
