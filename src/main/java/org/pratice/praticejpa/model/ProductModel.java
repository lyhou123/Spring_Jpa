package org.pratice.praticejpa.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="productpratice_tbl")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private float price;
    private String imageUrl;
}
