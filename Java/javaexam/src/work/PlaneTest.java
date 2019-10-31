package work;

class Airplane extends Plane {
	Airplane() {}
	Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	public void flight(int distance) {
		super.setFuelSize(getFuelSize() - (distance*3));
	}
}
class Cargoplane extends Plane {
	Cargoplane() {}
	Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	public void flight(int distance) {
		super.setFuelSize(getFuelSize() - (distance*5));
	}
}

public class PlaneTest {
	public static void main(String[] args) {
		Plane[] plane = new Plane[2];
		plane[0] = new Airplane("L747", 1000);
		plane[1] = new Cargoplane("C40", 1000);
		printInfo(plane);
		System.out.println();
		
		System.out.println("[100 운항]");
		for(Plane data : plane)
			data.flight(100);
		printInfo(plane);
		System.out.println();
		
		System.out.println("[200 주유]");
		for(Plane data : plane)
			data.refuel(200);
		printInfo(plane);
	}
	public static void printInfo(Plane[] list) {
		System.out.println("   Plane\tfuelSize");
		System.out.println("----------------------------");
		for(int i=0; i<list.length; i++) {
			System.out.println("   " + list[i].getPlaneName() + "\t\t" + list[i].getFuelSize());
		}
	}
}
