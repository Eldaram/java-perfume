package fr.eldaram.javaperfume.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "perfume")
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String shortDescription;
    private String price;

    @ManyToOne
    private Users users;

    @OneToMany
    private List<Photos> photos;
}
