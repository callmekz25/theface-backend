package com.codewithkz.productservice.dto.productimage;

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
public class ProductImageCreateUpdateRequestDTO extends BaseDTO {
    private String url;
    private String publicId;
    private int priority;
    private boolean isThumbnail;
}
