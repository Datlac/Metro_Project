package com.metro.model.people;

import com.metro.model.base.Person;
import java.time.LocalDate;

public class Staff extends Person {

    protected String employeeId;    // Mã nhân viên (VD: EMP-999)
    protected String department;    // Phòng ban (Kỹ thuật, Vận hành, CSKH)
    protected String jobTitle;      // Chức danh

    // Constructor
    public Staff(String id, String fullName, LocalDate dob, String phone, 
                 String employeeId, String department, String jobTitle) {
        super(id, fullName, dob, phone);
        this.employeeId = employeeId;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    @Override
    public String getRoleDescription() {
        return "Nhân viên: " + jobTitle + " - Phòng: " + department;
    }

    // --- GETTERS & SETTERS ---

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
}