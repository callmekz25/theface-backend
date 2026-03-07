package com.codewithkz.userservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Address extends BaseEntity {
    private String phoneNumber;
    private String provinceCode;
    private String provinceName;
    private String wardCode;
    private String wardName;
    private String street;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
