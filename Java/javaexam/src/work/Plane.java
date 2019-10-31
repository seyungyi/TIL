package work;

public abstract class Plane {
	private String planeName;
	private int fuelSize;
	
	Plane() {}
	Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	public String getPlaneName() {
		return planeName;
	}
	public String setPlaneName(String planeName) {
		return this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public int setFuelSize(int fuelSize) {
		return this.fuelSize = fuelSize;
	}
	public abstract void flight(int distance);
	//public abstract void refuel(int fuel);
	public void refuel(int fuel) {
		fuelSize += fuel;
	}
}
