package com.metro.gui;

import com.metro.data.MetroDataStore;
import com.metro.model.network.Station;
import com.metro.model.operation.Ticket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class AdminDashboard extends JFrame {

    private JTextField txtId, txtName;
    private DefaultTableModel stationTableModel, ticketTableModel;
    private JTable stationTable, ticketTable;

    public AdminDashboard() {
        setTitle("Dashboard Quản Trị Viên (Admin)");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- HEADER ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        JLabel lblTitle = new JLabel("HỆ THỐNG QUẢN TRỊ METRO");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle);
        
        add(headerPanel, BorderLayout.NORTH);

        // --- TABBED PANE ---
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Thêm Padding cho nội dung bên trong Tab
        tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        tabbedPane.addTab(" Quản lý Hạ Tầng ", createStationPanel());
        tabbedPane.addTab(" Lịch sử Vé Bán ", createTicketPanel());

        add(tabbedPane, BorderLayout.CENTER);

        // --- FOOTER ---
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnLogout = new JButton("Đăng xuất");
        styleButton(btnLogout, new Color(231, 76, 60));
        
        btnLogout.addActionListener(e -> {
            this.dispose();
            new LoginFrame().setVisible(true);
        });
        footerPanel.add(btnLogout);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createStationPanel() {
        JPanel panel = new JPanel(new BorderLayout(20, 0));

        // Form thêm mới (Trái)
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thêm Ga Mới"));
        inputPanel.setPreferredSize(new Dimension(300, 0));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;

        txtId = new JTextField(15);
        txtName = new JTextField(15);
        JButton btnAdd = new JButton("Lưu Trạm");
        styleButton(btnAdd, new Color(46, 204, 113));

        inputPanel.add(new JLabel("Mã Trạm:"), gbc);
        gbc.gridy++; inputPanel.add(txtId, gbc);
        gbc.gridy++; inputPanel.add(new JLabel("Tên Trạm:"), gbc);
        gbc.gridy++; inputPanel.add(txtName, gbc);
        gbc.gridy++; 
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(btnAdd, gbc);

        // Logic thêm trạm
        btnAdd.addActionListener(e -> {
            String id = txtId.getText();
            String name = txtName.getText();
            if(!id.isEmpty() && !name.isEmpty()) {
                MetroDataStore.getInstance().stations.add(new Station(id, name));
                loadStations();
                txtId.setText(""); txtName.setText("");
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            }
        });

        // Bảng danh sách (Phải)
        String[] cols = {"ID", "Tên Trạm", "Trạng thái"};
        stationTableModel = new DefaultTableModel(cols, 0);
        stationTable = new JTable(stationTableModel);
        stationTable.setRowHeight(25); // Tăng chiều cao dòng cho dễ đọc
        stationTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        loadStations();

        panel.add(inputPanel, BorderLayout.WEST);
        panel.add(new JScrollPane(stationTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createTicketPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] cols = {"Mã Vé", "Khách Hàng", "Loại Vé", "Giá (VNĐ)", "Ngày Mua", "Trạng Thái"};
        ticketTableModel = new DefaultTableModel(cols, 0);
        ticketTable = new JTable(ticketTableModel);
        ticketTable.setRowHeight(25);
        ticketTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        loadTickets();

        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRefresh = new JButton("Làm mới");
        JButton btnRevenue = new JButton("Báo cáo Doanh thu");
        
        styleButton(btnRefresh, new Color(52, 152, 219));
        styleButton(btnRevenue, new Color(155, 89, 182));

        btnRefresh.addActionListener(e -> loadTickets());
        btnRevenue.addActionListener(e -> {
            double total = MetroDataStore.getInstance().ticketHistory.stream().mapToDouble(Ticket::getPrice).sum();
            JOptionPane.showMessageDialog(this, "Tổng doanh thu: " + String.format("%,.0f", total) + " VNĐ");
        });

        toolbar.add(btnRefresh);
        toolbar.add(btnRevenue);

        panel.add(toolbar, BorderLayout.NORTH);
        panel.add(new JScrollPane(ticketTable), BorderLayout.CENTER);
        return panel;
    }

    private void styleButton(JButton btn, Color bgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
    }

    private void loadStations() {
        stationTableModel.setRowCount(0);
        for(Station s : MetroDataStore.getInstance().stations) {
            stationTableModel.addRow(new Object[]{s.getStationId(), s.getStationName(), s.getStatus()});
        }
    }

    private void loadTickets() {
        ticketTableModel.setRowCount(0);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for(Ticket t : MetroDataStore.getInstance().ticketHistory) {
            ticketTableModel.addRow(new Object[]{
                t.getTicketId(), t.getOwner().getFullName(), t.getType(),
                String.format("%,.0f", t.getPrice()), t.getIssueDate().format(fmt), t.getStatus()
            });
        }
    }
}