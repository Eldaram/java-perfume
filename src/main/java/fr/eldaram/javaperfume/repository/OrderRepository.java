package fr.eldaram.javaperfume.repository;

import fr.eldaram.javaperfume.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
