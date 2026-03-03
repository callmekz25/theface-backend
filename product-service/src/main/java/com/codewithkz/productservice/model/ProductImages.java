package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "product_images")
@Data
@SuperBuilder
@NoArgsConstructor
public class ProductImages extends BaseEntity {
    @Column(name = "url")
    private String url;
    @Column(name = "public_id")
    private String publicId;
    private int priority;
    @Column(name = "is_thumbnail")
    private boolean isThumbnail;
    @ManyToOne
    private Variant variant;

}
