package com.metro.model.people;

import com.metro.enums.CustomerType;
import com.metro.model.base.Person;
import java.time.LocalDate;

public class Customer extends Person {

    private String customerId;      // Mã khách hàng (VD: CUS-001)
    private CustomerType type;      // Loại khách (Sinh viên, Người già...)
    private double walletBalance;   // Số dư ví điện tử
    protected String membershipLevel;

    // Constructor
    public Customer(String id, String fullName, LocalDate dob, String phone, 
                    String customerId, CustomerType type) {
        super(id, fullName, dob, phone); // Gọi constructor của lớp cha Person
        this.customerId = customerId;
        this.type = type;
        this.walletBalance = 0.0; // Mặc định ví 0 đồng
        this.membershipLevel = "STANDARD";
    }

    // --- CÁC PHƯƠNG THỨC LOGIC NGHIỆP VỤ ---

    /**
     * Nạp tiền vào ví.
     * @param amount Số tiền nạp (> 0)
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền nạp phải lớn hơn 0.");
            return;
        }
        this.walletBalance += amount;
        System.out.println("Nạp thành công " + amount + ". Số dư mới: " + this.walletBalance);
    }

    /**
     * Trừ tiền trong ví (Khi mua vé).
     * @param amount Số tiền cần trừ
     * @return true nếu trừ thành công, false nếu không đủ tiền
     */
    public boolean deductBalance(double amount) {
        if (this.walletBalance >= amount) {
            this.walletBalance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getRoleDescription() {
        return "Hành khách (" + type.toString() + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " | Bal: " + walletBalance + " | Type: " + type;
    }

    // --- GETTERS & SETTERS ---

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public CustomerType getType() { return type; }
    public void setType(CustomerType type) { this.type = type; }

    public double getWalletBalance() { return walletBalance; }
    // Không có setWalletBalance public để đảm bảo an toàn dữ liệu, phải dùng deposit/deduct
}