package com.codewithkz.productservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "product_images")
@Data
@SuperBuilder
@NoArgsConstructor
public class ProductImage extends BaseEntity {
    @Column(name = "url")
    private String url;
    @Column(name = "public_id")
    private String publicId;
    private int priority;
    @Column(name = "is_thumbnail")
    private boolean isThumbnail;
    @ManyToOne(fetch = FetchType.LAZY)
    private Variant variant;

}
