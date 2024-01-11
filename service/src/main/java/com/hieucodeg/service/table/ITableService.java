package com.hieucodeg.service.table;

import com.hieucodeg.domain.dto.table.TableDTO;
import com.hieucodeg.domain.entity.CTable;
import com.hieucodeg.domain.enums.EnumTableStatus;
import com.hieucodeg.service.IGeneralService;

import java.util.List;


public interface ITableService extends IGeneralService<CTable> {
    List<TableDTO> getAllTableWhereDeletedIsFalse();

    List<TableDTO> getTablesWhereStatus(EnumTableStatus status);

    boolean existByName(String name);

    boolean existByNameAndIdIsNot(String name, Long id);

    void softDelete(Long id);
}
