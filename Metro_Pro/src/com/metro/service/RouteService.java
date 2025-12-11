package com.metro.service;

import com.metro.data.MetroDataStore;
import com.metro.model.network.Station;
import java.util.List;

public class RouteService {
	private static RouteService instance;

	private RouteService() {
	}

	public static RouteService getInstance() {
		if (instance == null)
			instance = new RouteService();
		return instance;
	}

	public int calculateStationDistance(String startStationName, String endStationName) {
		List<Station> stations = MetroDataStore.getInstance().stations;

		int startIndex = -1;
		int endIndex = -1;

		for (int i = 0; i < stations.size(); i++) {

			if (stations.get(i).toString().equals(startStationName)) {
				startIndex = i;
			}
			if (stations.get(i).toString().equals(endStationName)) {
				endIndex = i;
			}
		}

		if (startIndex != -1 && endIndex != -1) {
			return Math.abs(endIndex - startIndex);
		}

		return 0;
	}
}