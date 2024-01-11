package com.hieucodeg.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "database_check")
public class DatabaseCheck {
    @Id
    private Long id;

    @Column(name = "product_check")
    private int productCheck;

    @Column(name = "table_check")
    private int tableCheck;
}
