package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.attributevalue.AttributeValueCreateUpdateRequestDTO;
import com.codewithkz.productservice.mapper.AttributeMapper;
import com.codewithkz.productservice.mapper.AttributeValueMapper;
import com.codewithkz.productservice.model.Attribute;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.repository.AttributeRepository;
import com.codewithkz.productservice.repository.AttributeValueRepository;
import com.codewithkz.productservice.service.AttributeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AttributeServiceImpl extends BaseServiceImpl<Attribute, AttributeCreateUpdateRequestDTO, String> implements AttributeService {
    private final AttributeRepository repository;
    private final AttributeMapper mapper;
    private final AttributeValueRepository attributeValueRepository;
    private final AttributeValueMapper attributeValueMapper;

    public AttributeServiceImpl(AttributeRepository repository, AttributeMapper mapper, AttributeValueRepository attributeValueRepo, AttributeValueMapper attributeValueMapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.attributeValueRepository = attributeValueRepo;
        this.attributeValueMapper = attributeValueMapper;
    }

    @Override
    @Transactional
    public Attribute create(Attribute attribute) {
        return repository.save(attribute);
    }

    @Override
    @Transactional
    public List<AttributeValue> createAttributeValueList(Product product, List<AttributeCreateUpdateRequestDTO> attributes, Map<String, Attribute> attributeMap, Map<String, AttributeValue> attributeValueMap) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for (AttributeCreateUpdateRequestDTO attributeDTO : attributes) {
            // Attribute
            Attribute attribute = attributeMap.get(attributeDTO.getName());
            if(attribute == null) {
                AttributeCreateUpdateRequestDTO dto = AttributeCreateUpdateRequestDTO.builder()
                        .name(attributeDTO.getName())
                        .build();
                attribute = mapper.toEntity(dto);
                attribute.setProduct(product);
                attribute = create(attribute);
                attributeMap.put(attributeDTO.getName(), attribute);
            }

            // AttributeValue
            String key = attributeDTO.getName() + "_" + attributeDTO.getValue();
            AttributeValue attributeValue = attributeValueMap.get(key);
            if(attributeValue == null) {
                AttributeValueCreateUpdateRequestDTO attributeValueDTO = AttributeValueCreateUpdateRequestDTO.builder()
                        .value(attributeDTO.getValue())
                        .build();
                attributeValue = attributeValueMapper.toEntity(attributeValueDTO);
                attributeValue.setAttribute(attribute);
                attributeValue = attributeValueRepository.save(attributeValue);
                attributeValueMap.put(key, attributeValue);
            }
            attributeValues.add(attributeValue);
        }
        return attributeValues;
    }
}
