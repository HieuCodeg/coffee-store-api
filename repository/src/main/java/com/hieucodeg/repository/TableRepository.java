package com.hieucodeg.repository;

import com.hieucodeg.domain.dto.table.TableDTO;
import com.hieucodeg.domain.entity.CTable;
import com.hieucodeg.domain.enums.EnumTableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TableRepository extends JpaRepository<CTable, Long> {

    @Query("SELECT NEW com.hieucodeg.domain.dto.table.TableDTO (" +
                "tb.id, " +
                "tb.name, " +
                "tb.status " +
            ") " +
            "FROM CTable AS tb " +
            "WHERE tb.deleted = false "
    )
    List<TableDTO> getAllTableWhereDeletedIsFalse();

    @Query("SELECT NEW com.hieucodeg.domain.dto.table.TableDTO (" +
                "tb.id, " +
                "tb.name, " +
                "tb.status " +
            ") " +
            "FROM CTable AS tb " +
            "WHERE tb.deleted = false " +
            "AND " +
            "tb.status = :status"
    )
    List<TableDTO> getTablesWhereStatus(@Param("status") EnumTableStatus status);

    Boolean existsByName(String name);
    Boolean existsByNameAndIdIsNot(String name, Long id);

    @Modifying
    @Query("UPDATE CTable AS tb SET tb.deleted = true WHERE tb.id = :tableId")
    void softDelete(@Param("tableId") Long tableId);
}
