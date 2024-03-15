package fr.eldaram.announce.controller.dashboard;

import fr.eldaram.announce.model.Announce;
import fr.eldaram.announce.model.Users;
import fr.eldaram.announce.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;


    @GetMapping("/dashboard/announce")
    public String index(ModelMap map,@AuthenticationPrincipal Users users,@RequestParam(required = false) Integer id) {

        if (id != null) { // update
            map.put("announce", announceService.byId(id));
        }else{ // ajout
            map.put("announce", new Announce());
        }

        map.put("listAnnounce", announceService.byUser(users.getId()));

        return "dashboard/announce";
    }

    @PostMapping("/dashboard/announce")
    public String save(@ModelAttribute Announce announce,@AuthenticationPrincipal Users users) {
        announce.setUsers(users);
        announceService.save(announce);
        return "redirect:/dashboard/announce";
    }


}
