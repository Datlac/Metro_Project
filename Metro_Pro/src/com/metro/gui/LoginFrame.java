package com.metro.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Hệ thống Metro - Đăng nhập");
        // Mở rộng toàn màn hình
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Sử dụng GridBagLayout để căn giữa nội dung
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(240, 242, 245)); // Màu nền xám nhẹ hiện đại

        // --- TẠO PANEL ĐĂNG NHẬP (Cái hộp ở giữa) ---
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1, 10, 10));
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(30, 50, 30, 50) // Padding trong hộp
        ));
        loginPanel.setPreferredSize(new Dimension(400, 300)); // Kích thước cố định cho hộp

        // 1. Tiêu đề
        JLabel lblTitle = new JLabel("METRO SYSTEM", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(0, 102, 204));
        
        // 2. Label hướng dẫn
        JLabel lblInstruction = new JLabel("Vui lòng chọn vai trò truy cập:", SwingConstants.CENTER);
        lblInstruction.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // 3. ComboBox chọn Role
        String[] roles = {"Khách hàng (Customer)", "Nhân viên (Staff)", "Quản trị viên (Admin)"};
        JComboBox<String> cbRoles = new JComboBox<>(roles);
        cbRoles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbRoles.setBackground(Color.WHITE);

        // 4. Nút Login
        JButton btnLogin = new JButton("ĐĂNG NHẬP HỆ THỐNG");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Xử lý sự kiện
        btnLogin.addActionListener(e -> {
            int selectedIndex = cbRoles.getSelectedIndex();
            this.dispose(); // Đóng màn hình login thay vì chỉ ẩn

            switch (selectedIndex) {
                case 0: new CustomerDashboard().setVisible(true); break;
                case 1: new StaffDashboard().setVisible(true); break;
                case 2: new AdminDashboard().setVisible(true); break;
            }
        });

        // Thêm các thành phần vào hộp
        loginPanel.add(lblTitle);
        loginPanel.add(lblInstruction);
        loginPanel.add(cbRoles);
        loginPanel.add(btnLogin);

        // Thêm hộp vào màn hình chính
        add(loginPanel);
    }
}