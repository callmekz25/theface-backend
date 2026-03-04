package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@SuperBuilder
@NoArgsConstructor
public class Product extends BaseEntity {
    private String title;
    private String slug;
    private String description;
    private String origin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Builder.Default
    private List<Variant> variants = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_collections",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id")
    )
    @Builder.Default
    private List<Collection> collections = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Builder.Default
    private List<Attribute> attributes = new ArrayList<>();
}
