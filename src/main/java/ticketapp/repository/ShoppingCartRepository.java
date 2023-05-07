package ticketapp.repository;

import ticketapp.model.ShoppingCart;
import ticketapp.model.User;

public interface ShoppingCartRepository {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
