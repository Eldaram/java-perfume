package fr.eldaram.javaperfume.service;

import fr.eldaram.javaperfume.model.Role;
import fr.eldaram.javaperfume.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findOrSave(String nom) {
        Role role = roleRepository.findByNomIgnoreCase(nom);
        if (role != null) {
            return role;
        }

        role = new Role();
        role.setNom(nom);
        return roleRepository.save(role);
    }



}
