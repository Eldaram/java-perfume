package fr.eldaram.javaperfume.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<OrderedPerfumes> perfumes;

    @ManyToOne
    private Users users;

    private String date;
}
