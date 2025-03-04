package com.system.MegaCityCab.Exceptions;

public class InvalidBookingStateException extends RuntimeException{

    public InvalidBookingStateException(String message){
        super(message);
    }
}
