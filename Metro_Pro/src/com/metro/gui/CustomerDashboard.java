package com.metro.gui;

import com.metro.data.MetroDataStore;
import com.metro.enums.TicketType;
import com.metro.model.network.Station;
import com.metro.model.operation.Ticket;
import com.metro.model.people.Customer;
import com.metro.service.TicketService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CustomerDashboard extends JFrame {

    private JComboBox<Station> cbStart, cbEnd;
    private JComboBox<TicketType> cbTicketType;
    private JTextArea txtOutput;

    public CustomerDashboard() {
        setTitle("Metro - Khách hàng");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full Screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(39, 174, 96));
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        JLabel lblHeader = new JLabel("MUA VÉ TRỰC TUYẾN");
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 24));
        
        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setBackground(new Color(192, 57, 43));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(e -> { this.dispose(); new LoginFrame().setVisible(true); });

        headerPanel.add(lblHeader, BorderLayout.WEST);
        headerPanel.add(btnLogout, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Center Content (Chia 2 cột: Trái nhập liệu, Phải hiển thị vé)
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // --- Cột Trái: Form Mua Vé ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Thông tin hành trình"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1.0;

        List<Station> stationList = MetroDataStore.getInstance().stations;
        Station[] stations = stationList.toArray(new Station[0]);

        cbStart = new JComboBox<>(stations);
        cbEnd = new JComboBox<>(stations);
        cbTicketType = new JComboBox<>(TicketType.values());
        
        // Style ComboBox
        cbStart.setPreferredSize(new Dimension(0, 30));
        cbEnd.setPreferredSize(new Dimension(0, 30));

        formPanel.add(new JLabel("Ga Khởi Hành:"), gbc);
        gbc.gridy++; formPanel.add(cbStart, gbc);
        
        gbc.gridy++; formPanel.add(new JLabel("Ga Đến:"), gbc);
        gbc.gridy++; formPanel.add(cbEnd, gbc);
        
        gbc.gridy++; formPanel.add(new JLabel("Loại Vé:"), gbc);
        gbc.gridy++; formPanel.add(cbTicketType, gbc);

        JButton btnBuy = new JButton("XÁC NHẬN MUA VÉ");
        btnBuy.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBuy.setBackground(new Color(230, 126, 34));
        btnBuy.setForeground(Color.WHITE);
        btnBuy.setPreferredSize(new Dimension(0, 45));
        
        gbc.gridy++; 
        gbc.insets = new Insets(30, 10, 10, 10);
        formPanel.add(btnBuy, gbc);

        // --- Cột Phải: Vé điện tử ---
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtOutput.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Chi tiết Vé"));

        mainPanel.add(formPanel);
        mainPanel.add(scrollPane);
        add(mainPanel, BorderLayout.CENTER);

        // Logic Mua Vé
        btnBuy.addActionListener(e -> {
            Station start = (Station) cbStart.getSelectedItem();
            Station end = (Station) cbEnd.getSelectedItem();
            TicketType type = (TicketType) cbTicketType.getSelectedItem();

            if (start.equals(end)) {
                JOptionPane.showMessageDialog(this, "Ga đi và đến không được trùng nhau!");
                return;
            }

            Customer currentCustomer = MetroDataStore.getInstance().customers.get(0);
            Ticket ticket = TicketService.getInstance().purchaseTicket(currentCustomer, start.getStationName(), end.getStationName(), type);

            if (ticket != null) {
                txtOutput.setText("");
                txtOutput.append("=========================================\n");
                txtOutput.append("           VÉ TÀU ĐIỆN METRO             \n");
                txtOutput.append("=========================================\n\n");
                txtOutput.append(String.format(" Mã Vé:       %s\n", ticket.getTicketId()));
                txtOutput.append(String.format(" Khách Hàng:  %s\n", currentCustomer.getFullName()));
                txtOutput.append(String.format(" Hành Trình:  %s -> %s\n", start, end));
                txtOutput.append(String.format(" Loại Vé:     %s\n", type));
                txtOutput.append(String.format(" THÀNH TIỀN:  %,.0f VNĐ\n", ticket.getPrice()));
                txtOutput.append("\n=========================================\n");
                txtOutput.append(" Cảm ơn quý khách đã sử dụng dịch vụ!    \n");
                
                MetroDataStore.getInstance().ticketHistory.add(ticket);
            } else {
                txtOutput.setText("Giao dịch thất bại!");
            }
        });
    }
}