package com.metro.model.train;

import com.metro.model.base.RollingStock;

public class Locomotive extends RollingStock {

	// Constructor
	public Locomotive(String serialNumber, double weight, int manufactureYear) {
		// Gọi constructor của lớp cha (RollingStock)
		super(serialNumber, weight, manufactureYear);

	}

	@Override
	public String getTechnicalSpecs() {
		// TODO Auto-generated method stub
		return null;
	}
}