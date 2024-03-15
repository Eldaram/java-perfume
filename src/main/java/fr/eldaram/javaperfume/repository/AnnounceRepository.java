package fr.eldaram.announce.repository;

import fr.eldaram.announce.model.Announce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnounceRepository extends JpaRepository<Announce, Integer> {
    List<Announce> findByUsers_Id(Integer id);
}