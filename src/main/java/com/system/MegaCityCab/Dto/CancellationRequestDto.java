package com.system.MegaCityCab.Dto;

import lombok.Data;

@Data
public class CancellationRequestDto {
    private String bookingId;
    private String reason;
}
