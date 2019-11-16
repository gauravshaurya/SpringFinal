package com.iris.Spring1;

public class Vehicle {
	private String vehicleType;
	private int vehicleId;
	private Engine engine;
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", vehicleId=" + vehicleId + ", engine=" + engine + "]";
	}
		
}
