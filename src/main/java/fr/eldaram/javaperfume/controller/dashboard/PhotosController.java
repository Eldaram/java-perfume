package fr.eldaram.javaperfume.controller.dashboard;

import fr.eldaram.javaperfume.model.Perfume;
import fr.eldaram.javaperfume.model.Photos;
import fr.eldaram.javaperfume.model.Users;
import fr.eldaram.javaperfume.service.PerfumeService;
import fr.eldaram.javaperfume.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhotosController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private PerfumeService perfumeService;

    @GetMapping("/addPhoto")
    public String addPhoto(@RequestParam Integer idPerfume, ModelMap map) {
        map.put("idPerfume", idPerfume);
        return "addPhoto";
    }

    @PostMapping("/dashboard/photos/save")
    public Photos savePhoto(@ModelAttribute Photos photos) {
        return photoService.save(photos);
    }

    @PostMapping("/dashboard/photos/perfume/save")
    public Photos savePhoto(@RequestParam Integer idPerfume, @RequestParam Integer idPhoto) {
        Perfume perfume = perfumeService.byId(idPerfume);
        perfume.setPhoto(photoService.byId(idPhoto));
        perfumeService.save(perfume);
        return perfume.getPhoto();
    }

    @GetMapping("/dashboard/photos/perfume")
    public Photos byPerfume(@RequestParam Integer idPerfume) {
        return perfumeService.byId(idPerfume).getPhoto();
    }
}
