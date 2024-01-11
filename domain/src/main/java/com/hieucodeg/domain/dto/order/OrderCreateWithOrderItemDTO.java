package com.hieucodeg.domain.dto.order;

import com.hieucodeg.domain.dto.orderItem.OrderItemCreateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderCreateWithOrderItemDTO {

    private Long orderId;

    private Long staffId;

    private Long tableId;


    @Valid
    private List<OrderItemCreateDTO> orderItems;
}
