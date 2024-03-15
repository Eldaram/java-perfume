package fr.eldaram.announce.controller.dashboard;

import fr.eldaram.announce.model.Announce;
import fr.eldaram.announce.model.Photos;
import fr.eldaram.announce.service.AnnounceService;
import fr.eldaram.announce.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhotosController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private AnnounceService announceService;


    @PostMapping("/dashboard/photos/save")
    public Photos savePhoto(@ModelAttribute Photos photos) {
        return photoService.save(photos);
    }

    @PostMapping("/dashboard/photos/animal/save")
    public List<Photos> savePhoto(@RequestParam Integer idAnimal, @RequestParam Integer idPhoto) {
        Announce announce = announceService.byId(idAnimal);
        announce.getPhotos().add(photoService.byId(idPhoto));
        announceService.save(announce);
        return announce.getPhotos();
    }

    @GetMapping("/dashboard/photos/animal")
    public List<Photos> byAnimal(@RequestParam Integer idAnimal) {
        return announceService.byId(idAnimal).getPhotos();
    }
}
