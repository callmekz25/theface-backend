package com.codewithkz.paymentservice.model;


import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Payment extends BaseEntity {
    private String orderId;
    private Boolean paid;
    private Double amount;
}
