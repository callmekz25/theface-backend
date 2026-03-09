package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "variants")
@Data
@SuperBuilder
@NoArgsConstructor
public class Variant extends BaseEntity {
    private String sku;
    private Long price;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_default")
    private boolean isDefault;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "variant")
    private List<ProductImage> images;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "variant_attribute_values",
            joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_value_id")
    )
    @Builder.Default
    private List<AttributeValue> attributeValues = new ArrayList<>();
}
