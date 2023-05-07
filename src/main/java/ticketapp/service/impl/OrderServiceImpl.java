package ticketapp.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import ticketapp.model.Order;
import ticketapp.model.ShoppingCart;
import ticketapp.model.User;
import ticketapp.repository.OrderRepository;
import ticketapp.service.OrderService;
import ticketapp.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        orderRepository.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderRepository.getOrdersHistory(user);
    }
}
