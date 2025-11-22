import java.util.LinkedList;

public class Train {
	private String name;
	private boolean status;
	private Locomotive locomotive;
	private LinkedList<Carriage> carriageList;
	
	public Train(String name, boolean status, Locomotive locomotive, LinkedList<Carriage> carriageList) {
		super();
		this.name = name;
		this.status = status;
		this.locomotive = locomotive;
		this.carriageList = carriageList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Locomotive getLocomotive() {
		return locomotive;
	}
	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}
	public LinkedList<Carriage> getCarriageList() {
		return carriageList;
	}
	public void setCarriageList(LinkedList<Carriage> carriageList) {
		this.carriageList = carriageList;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public int getSeatQuantity() {
		int total = 0;
		for(Carriage c: carriageList) {
			total += c.getCurrentCustomer();
		}
		return total;
	}
	
	public int getTotalSeats() {
		int total = 0;
		for(Carriage c: carriageList) {
			total += c.getNumberOfSeats();
		}
		return total;
	}
}
