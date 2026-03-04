package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.dto.attributevalue.AttributeValueCreateUpdateRequestDTO;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.repository.AttributeValueRepository;
import com.codewithkz.productservice.service.AttributeValueService;
import org.springframework.stereotype.Service;

@Service
public class AttributeValueServiceImpl extends BaseServiceImpl<AttributeValue, AttributeValueCreateUpdateRequestDTO, String> implements AttributeValueService {
    public AttributeValueServiceImpl(AttributeValueRepository repository) {
        super(repository);
    }
}
