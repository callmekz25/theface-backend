package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@SuperBuilder
@NoArgsConstructor
public class Product extends BaseEntity {
    private String title;
    private int price;
    private String slug;
    private String description;
    private String origin;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Variant> variants;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_collections",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id")
    )
    private List<Collection> collections;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_attributes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    private Set<Attribute> attributes;
}
