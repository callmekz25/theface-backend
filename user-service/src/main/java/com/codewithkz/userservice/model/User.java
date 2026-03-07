package com.codewithkz.userservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "sso_id", unique = true)
    private String ssoId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

}
