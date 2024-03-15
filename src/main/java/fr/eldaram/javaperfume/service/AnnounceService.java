package fr.eldaram.announce.service;

import fr.eldaram.announce.repository.AnnounceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceService {

    @Autowired
    private AnnounceRepository announceRepository;

    public fr.eldaram.announce.model.Perfume save(fr.eldaram.announce.model.Perfume perfume) {
        return announceRepository.save(perfume);
    }

    public fr.eldaram.announce.model.Perfume byId(Integer id) {
        return announceRepository.findById(id).get();
    }

    public List<fr.eldaram.announce.model.Perfume> byUser(Integer idUser) {
        return announceRepository.findByUsers_Id(idUser);
    }
}
