package fr.eldaram.javaperfume.repository;

import fr.eldaram.javaperfume.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByNomIgnoreCase(String nom);
}