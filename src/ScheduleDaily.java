import java.util.Date;
import java.util.LinkedList;

public class ScheduleDaily {
	private Date date;
	private LinkedList<ScheduleDetail> details;
	
	public ScheduleDaily(Date date, LinkedList<ScheduleDetail> details) {
		super();
		this.date = date;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LinkedList<ScheduleDetail> getDetails() {
		return details;
	}
	public void setDetails(LinkedList<ScheduleDetail> details) {
		this.details = details;
	}
	
	
}
