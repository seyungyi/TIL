package mobile;

public abstract class Mobile {
	private String mobileName;
	private int batterySize;
	private String osType;
	Mobile() {}
	Mobile(String mobileName, int batterySize, String osType) {
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}	
	public String getMobileName() {
		return mobileName;
	}
	public String getOsType() {
		return osType;
	}
	public int getBatterySize() {
		return batterySize;
	}
	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;
	}
	public abstract void operate(int time);
	public abstract void charge(int time);
}