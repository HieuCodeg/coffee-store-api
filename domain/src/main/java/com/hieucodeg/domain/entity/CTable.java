package com.hieucodeg.domain.entity;


import com.hieucodeg.domain.dto.table.TableDTO;
import com.hieucodeg.domain.enums.EnumTableStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tables")
public class CTable extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EnumTableStatus status;


    public TableDTO toTableDTO() {
        return new TableDTO()
                .setId(id)
                .setName(name)
                .setStatus(String.valueOf(status))
                .setStatusValue(status.getValue());
    }
}
