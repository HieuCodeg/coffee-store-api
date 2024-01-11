package com.hieucodeg.domain.dto.order;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateDTO {

    private Long id;


    @Pattern(regexp = "^\\d+$", message = "Id bàn phải là số.")
    private Long tableId;

    @Pattern(regexp = "^\\d+$", message = "Id nhân viên phải là số.")
    private Long staffId;

}
