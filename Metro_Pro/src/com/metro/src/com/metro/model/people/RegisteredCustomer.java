package com.metro.model.people;

import com.metro.enums.CustomerType;
import java.time.LocalDate;
import java.util.Date;

public class RegisteredCustomer extends Customer {
    private String username;
    private String passwordHash;
    private Date registrationDate;

    public RegisteredCustomer(String id, String fullName, LocalDate dob, String phone, 
                              String customerId, String username, String passwordHash) {
        super(id, fullName, dob, phone, customerId, CustomerType.ADULT); // Mặc định hoặc truyền vào
        this.username = username;
        this.passwordHash = passwordHash;
        this.registrationDate = new Date();
    }

    public boolean login(String inputPassword) {
        // Logic kiểm tra hash password (giả lập)
        return this.passwordHash.equals(inputPassword);
    }

    // Getters Setters
}