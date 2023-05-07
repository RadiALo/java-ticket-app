package ticketapp.repository;

import java.util.List;
import ticketapp.model.Order;
import ticketapp.model.User;

public interface OrderRepository {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
