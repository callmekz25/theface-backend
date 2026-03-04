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
@Table(name = "attributes")
@Data
@SuperBuilder
@NoArgsConstructor
public class Attribute extends BaseEntity {
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attribute")
    @Builder.Default
    private List<AttributeValue> attributeValues = new ArrayList<>();
}

/*
Product
id
p1

A
id    name      p_id
a1    color     p1
a2    size      p1

A_V
id    value   a_id
av1   red     a1
av2   blue    a1
av3   small   a2
av4   medium  a2


V
id     price   p_id
v1     100     p1
v2     120     p1
v3     150     p1
v4     160     p1

V_A_V
id    v_id    a_v_id
va1   v1      av1
va2   v1      av2
 */