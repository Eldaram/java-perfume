package fr.eldaram.javaperfume.controller;

import fr.eldaram.javaperfume.model.Role;
import fr.eldaram.javaperfume.model.Users;
import fr.eldaram.javaperfume.service.PerfumeService;
import fr.eldaram.javaperfume.service.RoleService;
import fr.eldaram.javaperfume.service.UsersService;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
import java.util.List;

@Controller
public class SiteController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PerfumeService perfumeService;

    @GetMapping("/")
    public String index(ModelMap map) {
/*
        //Seulement pour les test
        Users user = usersService.byId(1);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authentication);
        HttpSession session = req.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return "redirect:/dashboard/animal";
*/
        if (!usersService.isUserExist("dragan@ribes.fr")) {
            Role roleAdmin = this.roleService.findOrSave("ADMIN");

            Users users = new Users();
            users.setNom("Ribes");
            users.setPrenom("Dragan");
            users.setEmail("dragan@ribes.fr");
            users.setActive(true);
            users.setMdp(bCryptPasswordEncoder.encode("1234"));
            users.setRoles(List.of(roleAdmin));
            this.usersService.save(users);
        }

        map.put("perfumeList", perfumeService.findAll());
        return "index";
    }

    @GetMapping("/addPerfume")
    public String addPerfume() {
        return "addPerfume";
    }

    @GetMapping("/dashboard/addPhoto/{idPerfume}")
    public String addPhoto(@PathVariable Integer idPerfume, ModelMap map) {
        map.put("idPerfume", idPerfume);
        return "dashboard/addPhoto";
    }

    @GetMapping("/login")
    public String login(ModelMap map) {
        map.put("user", new Users());
        return "login";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req, @ModelAttribute Users user) {

        user.setActive(true);
        user.setRoles(List.of(roleService.findOrSave("ADMIN")));
        user.setMdp(bCryptPasswordEncoder.encode(user.getMdp()));
        this.usersService.save(user);


        // ajouter une authentification
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authentication);
        HttpSession session = req.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return "redirect:/dashboard";
    }
}
