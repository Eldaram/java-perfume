package fr.eldaram.javaperfume.service;

import fr.eldaram.javaperfume.model.Photos;
import fr.eldaram.javaperfume.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private PhotosRepository photosRepository;

    public Photos save(Photos photos) {
        return photosRepository.save(photos);
    }

    public Photos byId(Integer id) {
        return photosRepository.findById(id).get();
    }
}
