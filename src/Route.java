import java.util.ArrayList;

public class Route {
	private String id;
	private String name;
	private ArrayList<RoutePart> routePartList;
	
	public Route(String id, String name, ArrayList<RoutePart> routePartList) {
		super();
		this.id = id;
		this.name = name;
		this.routePartList = routePartList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<RoutePart> getRoutePartList() {
		return routePartList;
	}

	public void setRoutePartList(ArrayList<RoutePart> routePartList) {
		this.routePartList = routePartList;
	}
	
	public Station getBeginStation() {
		
	}
}
