package fr.eldaram.javaperfume.service;

import fr.eldaram.javaperfume.model.Perfume;
import fr.eldaram.javaperfume.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    public Perfume save(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public List<Perfume> findAll() {
        return perfumeRepository.findAll();
    }

    public Perfume byId(Integer id) {
        return perfumeRepository.findById(id).get();
    }
}
