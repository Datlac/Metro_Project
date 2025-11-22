import java.util.Date;

public class Order {
	private String orderID;
	private String customerID;
	private Ticket ticket;
	private int amount;
	private double discount;
	private PaymentMethod paymentMethod;
	private OrderStatus orderStatus;
	private Date createdTime;
	private Date completedTime;
	private String description;
	
	public Order(String orderID, String customerID, Ticket ticket, int amount, double discount,
			PaymentMethod paymentMethod, OrderStatus orderStatus, Date createdTime, Date completedTime,
			String description) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.ticket = ticket;
		this.amount = amount;
		this.discount = discount;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.createdTime = createdTime;
		this.completedTime = completedTime;
		this.description = description;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
