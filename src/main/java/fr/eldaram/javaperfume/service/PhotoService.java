package fr.eldaram.announce.service;

import fr.eldaram.announce.model.Photos;
import fr.eldaram.announce.repository.PhotosRepository;
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
