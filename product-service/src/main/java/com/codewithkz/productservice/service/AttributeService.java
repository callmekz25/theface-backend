package com.codewithkz.productservice.service;


import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateRequestDTO;
import com.codewithkz.productservice.model.Attribute;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.model.Product;

import java.util.List;
import java.util.Map;

public interface AttributeService extends BaseService<Attribute, AttributeCreateUpdateRequestDTO, String> {
    List<AttributeValue> createAttributeValueList(Product product, List<AttributeCreateUpdateRequestDTO> attributes, Map<String, Attribute> attributeMap, Map<String, AttributeValue> attributeValueMap);
}
