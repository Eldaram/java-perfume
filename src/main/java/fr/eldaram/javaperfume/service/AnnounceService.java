package fr.eldaram.announce.service;

import fr.eldaram.announce.model.Announce;
import fr.eldaram.announce.repository.AnnounceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceService {

    @Autowired
    private AnnounceRepository announceRepository;

    public Announce save(Announce announce) {
        return announceRepository.save(announce);
    }

    public Announce byId(Integer id) {
        return announceRepository.findById(id).get();
    }

    public List<Announce> byUser(Integer idUser) {
        return announceRepository.findByUsers_Id(idUser);
    }
}
