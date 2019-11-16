package com.iris.Spring1;

public class Engine {
	private int engineId;
	private String engineName;
	private int engineCapacity;
	
	public Engine() {
		
	}
	
	public Engine(int engineId, String engineName, int engineCapacity) {
		super();
		this.engineId = engineId;
		this.engineName = engineName;
		this.engineCapacity = engineCapacity;
	}

	@Override
	public String toString() {
		return "Engine [engineId=" + engineId + ", engineName=" + engineName + ", engineCapacity=" + engineCapacity
				+ "]";
	}
	
	
}
