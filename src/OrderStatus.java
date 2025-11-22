
public class OrderStatus {
	private static final String pending = "PENDING";
	private static final String completed = "COMPLETED";
	private static final String cancelled = "CANCELLED";
	private static final String failed = "FAILED";
	
	public static String getPending() {
		return pending;
	}
	public static String getCompleted() {
		return completed;
	}
	public static String getCancelled() {
		return cancelled;
	}
	public static String getFailed() {
		return failed;
	}
	
	
}
