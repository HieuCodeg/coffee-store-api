package com.hieucodeg.service.order;

import com.hieucodeg.domain.dto.order.*;
import com.hieucodeg.domain.dto.orderItem.OrderItemKitchenTableDTO;
import com.hieucodeg.domain.dto.report.ReportDTO;
import com.hieucodeg.domain.dto.report.ReportDayToDayDTO;
import com.hieucodeg.domain.dto.report.ReportYearDTO;
import com.hieucodeg.domain.entity.Order;
import com.hieucodeg.domain.enums.EnumOrderItemStatus;
import com.hieucodeg.domain.enums.EnumOrderStatus;
import com.hieucodeg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderService extends IGeneralService<Order> {
    List<OrderDTO> getAllOrderDTOWhereDeletedIsFalse();

    List<OrderDTO> getAllOrderDTOByDayToDay(String startDay, String endDay);

    List<OrderDTO> getOrderDTOByStatus(EnumOrderStatus orderStatus);


    List<OrderKitchenDTO> getAllOrderKitchenByTable(EnumOrderItemStatus orderItemStatus);

    int countProductInOrder(List<OrderItemKitchenTableDTO> orderItemList);

    List<OrderDTO> getOrderDTOByTableIdAndOrderStatus(Long tableId, EnumOrderStatus orderStatus);


    OrderResponseDTO createWithOrderItems(OrderCreateWithOrderItemDTO orderCreateWithOrderItemDTO);

    OrderResponseDTO updateWithOrderItems(OrderCreateWithOrderItemDTO orderCreateWithOrderItemDTO);

    BigDecimal calculateTotalAmount(Long orderId);

    List<OrderCountCurrentMonthDTO> countOrderOfCurrentDay();

    void softDelete(Long id);

    List<ReportYearDTO> getReportByYear(int year);

    List<ReportYearDTO> getReportByMonth(int month, int year);

//    List<ReportDTO> getReportOfCurrentMonth();

    List<ReportDTO> getReportOfDay(String day);

    List<ReportDayToDayDTO> getReportFromDayToDay(String startDay, String endDay);

    void deleteOrderById(Long orderId);

    OrderPayDTO pay(Order order);
}
