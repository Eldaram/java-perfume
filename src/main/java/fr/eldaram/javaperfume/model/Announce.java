package fr.eldaram.announce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "announce")
@Data
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String city;
    private String zipCode;
    private String country;

    @ManyToOne
    private Users users;

    @OneToMany
    private List<Photos> photos;
}
