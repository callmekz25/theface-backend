package com.codewithkz.commonlibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    protected Instant updatedAt;
    @Column(name = "deleted_at")
    protected Instant deletedAt;
}
