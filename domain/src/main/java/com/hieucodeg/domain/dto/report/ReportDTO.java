package com.hieucodeg.domain.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {

    private BigDecimal totalAmount;
}
