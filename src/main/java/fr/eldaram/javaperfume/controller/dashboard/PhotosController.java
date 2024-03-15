package fr.eldaram.javaperfume.controller.dashboard;

import fr.eldaram.javaperfume.model.Perfume;
import fr.eldaram.javaperfume.model.Photos;
import fr.eldaram.javaperfume.service.PerfumeService;
import fr.eldaram.javaperfume.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhotosController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private PerfumeService perfumeService;


    @PostMapping("/dashboard/photos/save")
    public Photos savePhoto(@ModelAttribute Photos photos) {
        return photoService.save(photos);
    }

    @PostMapping("/dashboard/photos/perfume/save")
    public List<Photos> savePhoto(@RequestParam Integer idPerfume, @RequestParam Integer idPhoto) {
        Perfume perfume = perfumeService.byId(idPerfume);
        perfume.getPhotos().add(photoService.byId(idPhoto));
        perfumeService.save(perfume);
        return perfume.getPhotos();
    }

    @GetMapping("/dashboard/photos/perfume")
    public List<Photos> byPerfume(@RequestParam Integer idPerfume) {
        return perfumeService.byId(idPerfume).getPhotos();
    }
}
