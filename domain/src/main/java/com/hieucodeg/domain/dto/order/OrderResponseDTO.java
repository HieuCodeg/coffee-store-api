package com.hieucodeg.domain.dto.order;

import com.hieucodeg.domain.dto.orderItem.OrderItemResponseDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {

    private Long orderId;

    private Long staffId;

    private Long tableId;

    private BigDecimal totalAmount;


    @Valid
    private List<OrderItemResponseDTO> orderItems;

}
