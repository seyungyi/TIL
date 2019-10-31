package mobile;

class Ltab extends Mobile {
	Ltab() {}
	Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	public void operate(int time) {
		setBatterySize(getBatterySize() - time*10);
	}
	public void charge(int time) {
		setBatterySize(getBatterySize() + time*10);
	}	
}

class Otab extends Mobile {
	Otab() {}
	Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	public void operate(int time) {
		setBatterySize(getBatterySize() - time*12);
	}
	public void charge(int time) {
		setBatterySize(getBatterySize() + time*8);
	}
}

public class MobileTest {
	public static void main(String[] args) {
		Ltab lt = new Ltab("Ltab", 500, "ABC-01");
		Otab ot = new Otab("Otab", 1000, "XYZ-20");
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		System.out.println("[10분 충전]");
		printTitle();
		lt.charge(10);
		ot.charge(10);
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		System.out.println("[5분 통화]");
		printTitle();
		lt.operate(5);
		ot.operate(5);
		printMobile(lt);
		printMobile(ot);
	}
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName() + "\t\t" + 
					mobile.getBatterySize() + "\t\t" + mobile.getOsType());
    }
    public static void printTitle() {
    	System.out.println("Mobile\t\tBattery\t\tOS");
    	System.out.println("---------------------------------------------");
    }
}
