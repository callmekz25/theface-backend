package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "attributes")
@Data
@SuperBuilder
@NoArgsConstructor
public class Attribute extends BaseEntity {
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_attributes",
            joinColumns = @JoinColumn(name = "attribute_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @OneToMany(fetch = FetchType.LAZY)
    private List<AttributeValue> attributeValues;
}

/*
Product
id
p1

A
id    name
a1    color

A_V
id    value   a_id
av1   red     a1
av2   blue    a1


P_A
id     p_id    a_id
pa1     p1      a1

V
id     price   p_id
v1     100     p1
v2     120     p1

V_A_V
id    v_id    a_id
va1   v1      a1
va2   v2      a1
 */