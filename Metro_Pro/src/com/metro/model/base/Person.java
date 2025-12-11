package com.metro.model.base;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Lớp trừu tượng đại diện cho thông tin cơ bản của một con người.
 * Các lớp con (Customer, Staff, Driver) sẽ kế thừa từ lớp này.
 */
public abstract class Person {
    
    protected String id;            // CMND/CCCD hoặc ID định danh hệ thống
    protected String fullName;      // Họ và tên đầy đủ
    protected LocalDate dateOfBirth; // Ngày sinh
    protected String phoneNumber;   // Số điện thoại
    protected String email;         // Email (tùy chọn)

    // Constructor đầy đủ
    public Person(String id, String fullName, LocalDate dateOfBirth, String phoneNumber) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID không được để trống");
        }
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    // --- CÁC PHƯƠNG THỨC LOGIC CHUNG ---

    /**
     * Tính tuổi dựa trên ngày sinh.
     * @return số tuổi (int)
     */
    public int getAge() {
        if (dateOfBirth == null) return 0;
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * Phương thức trừu tượng: Buộc các lớp con phải tự định nghĩa vai trò của mình.
     * Ví dụ: Customer sẽ trả về "VIP Member", Staff trả về "Trưởng phòng".
     */
    public abstract String getRoleDescription();

    // --- GETTERS & SETTERS ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // --- OVERRIDE OBJECT METHODS ---
    // Giúp so sánh 2 người dựa trên ID thay vì địa chỉ vùng nhớ
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return fullName + " (ID: " + id + ")";
    }
}