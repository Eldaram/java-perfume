package fr.eldaram.javaperfume.service;

import fr.eldaram.javaperfume.model.Order;
import fr.eldaram.javaperfume.model.Users;
import fr.eldaram.javaperfume.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }

    public List<Order> getByUser(Users users) {
        return orderRepository.findOrdersByUsers(users);
    }
}
