package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "collections")
@Data
@SuperBuilder
@NoArgsConstructor
public class Collection extends BaseEntity {
    private String name;
    private String slug;
    @Column(name = "parent_collection_id")
    private String parentCollectionId;
    private String thumbnail;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_show_home_page")
    private boolean isShowHomePage;
    @Column(name = "is_filter")
    private boolean isFilter;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "collections")
    private List<Product> products;
}
