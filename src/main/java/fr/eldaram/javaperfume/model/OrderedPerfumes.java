package fr.eldaram.javaperfume.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orderedPerfume")
@Data
public class OrderedPerfumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Perfume perfume;

    private Integer price;
}
