package com.metro.data;

import com.metro.enums.*;
import com.metro.model.network.*;
import com.metro.model.people.*;
import com.metro.model.train.*;
import com.metro.model.operation.*; // Nếu cần lưu vé

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Singleton đóng vai trò là Cơ sở dữ liệu trong bộ nhớ (In-memory
 * Database). Chứa danh sách các đối tượng Station, Line, Train, Customer...
 */
public class MetroDataStore {

	// 1. Instance duy nhất (Singleton Pattern)
	private static MetroDataStore instance;

	// 2. Các danh sách lưu trữ dữ liệu (Tables)
	public List<Station> stations;
	public List<Line> lines;
	public List<Train> trains;
	public List<Customer> customers;
	public List<Staff> staffList;
	public List<Ticket> ticketHistory; // Lưu lịch sử vé đã mua

	// 3. Constructor Private: Khởi tạo dữ liệu mẫu ngay khi app chạy
	private MetroDataStore() {
		// Khởi tạo các list
		stations = new ArrayList<>();
		lines = new ArrayList<>();
		trains = new ArrayList<>();
		customers = new ArrayList<>();
		staffList = new ArrayList<>();
		ticketHistory = new ArrayList<>();

		// --- GỌI CÁC HÀM TẠO DỮ LIỆU MẪU (SEED DATA) ---
		initStationsAndLines();
		initTrains();
		initPeople();
	}

	// 4. Phương thức lấy instance duy nhất
	public static MetroDataStore getInstance() {
		if (instance == null) {
			instance = new MetroDataStore();
		}
		return instance;
	}

	// ==========================================
	// PHẦN KHỞI TẠO DỮ LIỆU MẪU (MOCK DATA)
	// ==========================================

	private void initStationsAndLines() {
		// Tạo các nhà ga (Mô phỏng tuyến Metro số 1 TP.HCM)
		Station s1 = new Station("S01", "Bến Thành");
		Station s2 = new Station("S02", "Nhà hát Thành phố");
		Station s3 = new Station("S03", "Ba Son");
		Station s4 = new Station("S04", "Văn Thánh");
		Station s5 = new Station("S05", "Tân Cảng");
		Station s6 = new Station("S06", "Thảo Điền");

		stations.add(s1);
		stations.add(s2);
		stations.add(s3);
		stations.add(s4);
		stations.add(s5);
		stations.add(s6);

		// Tạo tuyến đường (Line) và thêm ga vào
		Line line1 = new Line("L01", "Tuyến số 1: Bến Thành - Suối Tiên");
		line1.addStation(s1);
		line1.addStation(s2);
		line1.addStation(s3);
		line1.addStation(s4);
		line1.addStation(s5);
		line1.addStation(s6);

		lines.add(line1);
	}

	private void initTrains() {
		// Tạo tàu số 1
		Train t1 = new Train("VN-METRO-01");
		t1.setStatus(TrainStatus.IDLE);

		// Thêm đầu máy (Nặng 50 tấn, 3000kW)
		Locomotive loc1 = new Locomotive("LOC-01-A", 50.0, 3000);
		t1.addLocomotive(loc1);

		// Thêm 3 toa hành khách
		// Toa 1: 45 ghế, 100 đứng
		t1.addCarriage(new Carriage("CAR-01-01", 35.0, 2024, 45, 100));
		t1.addCarriage(new Carriage("CAR-01-02", 35.0, 2024, 45, 100));
		t1.addCarriage(new Carriage("CAR-01-03", 35.0, 2024, 45, 100));

		trains.add(t1);

		// Tạo tàu số 2 (Đang bảo trì)
		Train t2 = new Train("VN-METRO-02");
		t2.setStatus(TrainStatus.MAINTENANCE);
		t2.addLocomotive(new Locomotive("LOC-02-A", 52.0, 3200));
		t2.addCarriage(new Carriage("CAR-02-01", 36.0, 2024, 50, 120));

		trains.add(t2);
	}

	// Đảm bảo đã import thư viện này ở đầu file
	// import java.time.LocalDate;

	private void initPeople() {
		// ---------------------------------------------------------
		// TẠO KHÁCH HÀNG (CUSTOMER)
		// Constructor: Customer(PersonID, Name, DOB, Phone, CustomerID, Type)
		// ---------------------------------------------------------

		// Khách 1: Người lớn
		Customer c1 = new Customer("079090000001", // Person ID (CCCD)
				"Nguyễn Văn An", // Tên
				LocalDate.of(1990, 5, 20), // Ngày sinh
				"0909123456", // SĐT
				"CUS001", // Mã khách hàng
				CustomerType.ADULT // Loại khách
		);
		c1.deposit(500000);
		customers.add(c1);

		// Khách 2: Sinh viên
		Customer c2 = new Customer("079090000002", "Trần Thị Bích", LocalDate.of(2003, 8, 15), "0912345678", "CUS002",
				CustomerType.STUDENT);
		c2.deposit(100000);
		customers.add(c2);

		// Khách 3: Người cao tuổi
		Customer c3 = new Customer("079090000003", "Lê Văn Cẩn", LocalDate.of(1955, 1, 1), "0988777666", "CUS003",
				CustomerType.SENIOR);
		c3.deposit(20000);
		customers.add(c3);

		// ---------------------------------------------------------
		// TẠO NHÂN VIÊN (STAFF)
		// Constructor: Staff(PersonID, Name, DOB, Phone, EmployeeID, Dept, JobTitle)
		// ---------------------------------------------------------

		Staff staff1 = new Staff("079088000001", "Phạm Quản Lý", LocalDate.of(1985, 10, 10), "0977111222", "ST001",
				"Vận hành", "Trưởng ca trực");
		staffList.add(staff1);

		// ---------------------------------------------------------
		// TẠO LÁI TÀU (DRIVER)
		// Constructor: Driver(PersonID, Name, DOB, Phone, EmployeeID, Dept, LicenseNum,
		// ExpiryDate)
		// ---------------------------------------------------------

		Driver driver1 = new Driver("079088000002", "Võ Lái Tàu", LocalDate.of(1988, 12, 20), "0966555444", "DR001",
				"Kỹ thuật", "LICENSE-A1-999", // Số bằng lái
				LocalDate.of(2030, 12, 31) // Ngày hết hạn bằng
		);
		staffList.add(driver1);
	}
}