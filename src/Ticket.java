import java.util.Date;

public class Ticket {
	private String ticketID;
	private Customer customer;
	private Route route;
	private Date date;
	private TicketType ticketType;
	private double price;
	private boolean isActivated;
	private int maxRides;
	private int ridesUsed;
	private TicketStatus status;
	
	public Ticket(String ticketID, Customer customer, Route route, Date date, TicketType ticketType, double price,
			boolean isActivated, int maxRides, int ridesUsed, TicketStatus status) {
		super();
		this.ticketID = ticketID;
		this.customer = customer;
		this.route = route;
		this.date = date;
		this.ticketType = ticketType;
		this.price = price;
		this.isActivated = isActivated;
		this.maxRides = maxRides;
		this.ridesUsed = ridesUsed;
		this.status = status;
	}
	
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public int getMaxRides() {
		return maxRides;
	}
	public void setMaxRides(int maxRides) {
		this.maxRides = maxRides;
	}
	public int getRidesUsed() {
		return ridesUsed;
	}
	public void setRidesUsed(int ridesUsed) {
		this.ridesUsed = ridesUsed;
	}
	public TicketStatus getStatus() {
		return status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	
}
