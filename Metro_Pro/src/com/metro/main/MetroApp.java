package com.metro.main;

import com.metro.gui.LoginFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class chính để chạy ứng dụng Metro System.
 */
public class MetroApp {

    public static void main(String[] args) {
        // Chạy ứng dụng trên luồng sự kiện của Swing (Event Dispatch Thread)
        // để đảm bảo an toàn luồng (Thread-safety) cho giao diện.
        SwingUtilities.invokeLater(() -> {
            configureLookAndFeel();
            launchApplication();
        });
    }

    /**
     * Thiết lập giao diện để ứng dụng trông giống giao diện hệ điều hành (Windows/Mac/Linux)
     * thay vì giao diện Java Swing mặc định (Metal look) trông khá cũ.
     */
    private static void configureLookAndFeel() {
        try {
            // Cố gắng set giao diện theo hệ thống đang chạy
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            // Nếu lỗi, in ra console và tiếp tục dùng giao diện mặc định
            System.err.println("Không thể thiết lập giao diện hệ thống: " + e.getMessage());
        }
    }

    /**
     * Khởi tạo và hiển thị màn hình đăng nhập.
     */
    private static void launchApplication() {
        try {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            System.out.println("Ứng dụng Metro System đã khởi động thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Đã xảy ra lỗi nghiêm trọng khi khởi động ứng dụng.");
        }
    }
}