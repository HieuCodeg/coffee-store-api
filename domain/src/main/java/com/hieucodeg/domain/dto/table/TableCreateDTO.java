package com.hieucodeg.domain.dto.table;

import com.hieucodeg.domain.entity.CTable;
import com.hieucodeg.domain.enums.EnumTableStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TableCreateDTO {

    private Long id;

    @NotEmpty(message = "Vui lòng nhập tên bàn.")
    @Size(min = 4, max = 20, message = "Tên bàn có độ dài nằm trong khoảng 4 - 20 ký tự.")
    private String name;


    private CTable toTable(){
        return new CTable()
                .setId(id)
                .setName(name)
                .setStatus(EnumTableStatus.EMPTY);
    }
}
