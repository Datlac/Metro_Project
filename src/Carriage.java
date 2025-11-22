
public class Carriage {
	private String id;
	private int numberOfSeats;
	private int currentCustomer;
	
	public Carriage(String id, int numberOfSeats, int currentCustomer) {
		super();
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.currentCustomer = currentCustomer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(int currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	
}
