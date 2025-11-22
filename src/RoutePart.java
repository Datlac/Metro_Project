
public class RoutePart {
	private Station beginStation;
	private Station endStation;
	private double distanceToNext;
	
	public RoutePart(Station beginStation, Station endStation, double distanceToNext) {
		super();
		this.beginStation = beginStation;
		this.endStation = endStation;
		this.distanceToNext = distanceToNext;
	}

	public Station getBeginStation() {
		return beginStation;
	}

	public void setBeginStation(Station beginStation) {
		this.beginStation = beginStation;
	}

	public Station getEndStation() {
		return endStation;
	}

	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}

	public double getDistanceToNext() {
		return distanceToNext;
	}

	public void setDistanceToNext(double distanceToNext) {
		this.distanceToNext = distanceToNext;
	}
	
	
}
