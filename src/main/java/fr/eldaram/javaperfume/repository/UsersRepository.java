package fr.eldaram.javaperfume.repository;

import fr.eldaram.javaperfume.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmailLikeIgnoreCase(String email);
}
