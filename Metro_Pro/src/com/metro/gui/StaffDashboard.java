package com.metro.gui;

import com.metro.data.MetroDataStore;
import com.metro.enums.TrainStatus;
import com.metro.model.train.Train;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StaffDashboard extends JFrame {

    private JTable trainTable;
    private DefaultTableModel tableModel;

    public StaffDashboard() {
        setTitle("Quản lý Vận hành Tàu");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JLabel lblHeader = new JLabel("TRUNG TÂM ĐIỀU HÀNH (OCC)", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(lblHeader, BorderLayout.NORTH);

        // Bảng dữ liệu
        String[] columns = {"Mã Tàu", "Số Đầu Máy", "Số Toa", "Tổng Sức Chứa", "Trạng Thái"};
        tableModel = new DefaultTableModel(columns, 0);
        trainTable = new JTable(tableModel);
        loadTrainData(); // Nạp dữ liệu ban đầu

        add(new JScrollPane(trainTable), BorderLayout.CENTER);

        // Panel chức năng
        JPanel actionPanel = new JPanel();
        JButton btnMaintenance = new JButton("Bảo trì");
        JButton btnRunning = new JButton("Vận hành");
        JButton btnRefresh = new JButton("Làm mới");
        JButton btnLogout = new JButton("Đăng xuất");

        btnMaintenance.addActionListener(e -> updateStatus(TrainStatus.MAINTENANCE));
        btnRunning.addActionListener(e -> updateStatus(TrainStatus.RUNNING));
        btnRefresh.addActionListener(e -> loadTrainData());
        btnLogout.addActionListener(e -> {
            this.dispose();
            new LoginFrame().setVisible(true);
        });

        actionPanel.add(btnRunning);
        actionPanel.add(btnMaintenance);
        actionPanel.add(btnRefresh);
        actionPanel.add(btnLogout);

        add(actionPanel, BorderLayout.SOUTH);
    }

    private void loadTrainData() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        for (Train t : MetroDataStore.getInstance().trains) {
            Object[] row = {
                t.getTrainCode(),
                t.getLocomotives().size(),
                t.getCarriages().size(),
                t.calculateTotalCapacity(), // Gọi phương thức tính toán động
                t.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void updateStatus(TrainStatus status) {
        int selectedRow = trainTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một đoàn tàu!");
            return;
        }

        // Cập nhật vào Model thật trong DataStore
        Train selectedTrain = MetroDataStore.getInstance().trains.get(selectedRow);
        selectedTrain.setStatus(status);
        
        // Cập nhật lại giao diện
        loadTrainData();
        JOptionPane.showMessageDialog(this, "Đã cập nhật trạng thái tàu " + selectedTrain.getTrainCode());
    }
}