package com.system.MegaCityCab.Dto;

import lombok.Data;

@Data

public class BookingRequestDto {
   private String customerId;
    private String carId;
    private String pickupLocation;
    private String dropLocation;
    private String pickupDate;
    private boolean driverRequired;
    
}
