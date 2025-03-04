package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Booking;

@Service

public interface BookingService {

     List<Booking> getAllBookings();

    Booking getBookingById(String bookingId);

    Booking createBooking(com.system.MegaCityCab.Dto.BookingRequestDto request);

    Booking cancelBooking(String customerId, com.system.MegaCityCab.Dto.CancellationRequestDto request);

    List<Booking> getCustomerBookings(String customerId);

    Booking getBookingDetails(String customerId, String bookingId);

    void deleteBooking(String bookingId, String customerId);
    
}
