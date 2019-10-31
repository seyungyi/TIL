package day2;

public class ForLab2 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 8) + 3; // 3~10
		int num2 = (int) (Math.random() * 3) + 1; // 1~3
		String output = "";
		switch (num2) {
		case 1:
			output = "*";
			break;
		case 2:
			output = "$";
			break;
		case 3:
			output = "#";
			break;
		}
		for (int i = 1; i <= num1; i++) {
			System.out.print(output);
			}
	}

}
