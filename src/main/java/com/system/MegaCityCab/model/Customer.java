package com.system.MegaCityCab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "customer")
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String email;
    private String customerpNo;
    private String userName;
    private String password;
}
