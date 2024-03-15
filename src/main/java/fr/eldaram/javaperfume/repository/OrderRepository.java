package fr.eldaram.javaperfume.repository;

import fr.eldaram.javaperfume.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByUsers(Integer id);
}
