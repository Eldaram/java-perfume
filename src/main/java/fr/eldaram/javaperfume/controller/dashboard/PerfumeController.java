package fr.eldaram.javaperfume.controller.dashboard;

import fr.eldaram.javaperfume.model.Perfume;
import fr.eldaram.javaperfume.model.Users;
import fr.eldaram.javaperfume.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;


    @GetMapping("/dashboard/perfume")
    public String index(ModelMap map,@AuthenticationPrincipal Users users,@RequestParam(required = false) Integer id) {

        if (id != null) { // update
            map.put("announce", perfumeService.byId(id));
        }else{ // ajout
            map.put("announce", new Perfume());
        }

        return "dashboard/announce";
    }

    @PostMapping("/dashboard/perfume")
    public String save(@ModelAttribute Perfume perfume) {
        Perfume addedPerfume = perfumeService.save(perfume);
        return "redirect:/dashboard/addPhoto/" + addedPerfume.getId();
    }


}
