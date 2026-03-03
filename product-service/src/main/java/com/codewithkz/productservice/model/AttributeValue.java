package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "attribute_values")
@Data
@SuperBuilder
@NoArgsConstructor
public class AttributeValue extends BaseEntity {
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attribute attribute;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "variant_attribute_values",
            joinColumns = @JoinColumn(name = "attribute_value_id"),
            inverseJoinColumns = @JoinColumn(name = "variant_id")
    )
    private List<Variant> variants;
}
