package com.system.MegaCityCab.Dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDto {

    private String bookingId;
    private String pickupLocation;
    private  String dropLocation;
    private BigDecimal fare;
    private BigDecimal tax;
    private BigDecimal totalAmount;
    private String bookingStatus;
    private String bookingDate;
}
