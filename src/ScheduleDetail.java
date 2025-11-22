import java.util.Date;

public class ScheduleDetail {
	private Date date;
	private double timeStart;
	private double timeEnd;
	private Train train;
	private Route route;
	
	public ScheduleDetail(Date date, double timeStart, double timeEnd, Train train, Route route) {
		super();
		this.date = date;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.train = train;
		this.route = route;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(double timeStart) {
		this.timeStart = timeStart;
	}
	public double getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(double timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	
}
