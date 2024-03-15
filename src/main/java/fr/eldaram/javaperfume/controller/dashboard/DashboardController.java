package fr.eldaram.announce.controller.dashboard;

import fr.eldaram.announce.model.Users;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String index() {
        return "dashboard/index";
    }

}
