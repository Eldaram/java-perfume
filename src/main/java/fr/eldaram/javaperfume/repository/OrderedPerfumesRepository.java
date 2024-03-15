package fr.eldaram.javaperfume.repository;

import fr.eldaram.javaperfume.model.OrderedPerfumes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedPerfumesRepository extends JpaRepository<OrderedPerfumes, Integer> {
}
