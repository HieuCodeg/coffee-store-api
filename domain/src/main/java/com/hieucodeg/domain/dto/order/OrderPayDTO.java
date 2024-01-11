package com.hieucodeg.domain.dto.order;

import com.hieucodeg.domain.dto.orderItem.OrderItemResponseDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderPayDTO {

    private Long orderId;

    private String staffName;

    private String tableName;

    private BigDecimal totalAmount;

   private Date creatAt;


    @Valid
    private List<OrderItemResponseDTO> orderItems;

}
