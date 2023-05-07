package ticketapp.service;

import java.util.List;
import ticketapp.model.Order;
import ticketapp.model.ShoppingCart;
import ticketapp.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
