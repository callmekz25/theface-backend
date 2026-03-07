package com.codewithkz.productservice.dto.collection;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CollectionCreateUpdateResponseDTO extends BaseDTO {
    private String name;
    private String slug;
    private String parentId;
    private String description;
    private boolean isActive;
    private boolean isShowHomePage;
}