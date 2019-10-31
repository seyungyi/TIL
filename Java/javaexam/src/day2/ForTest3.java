package day2;

public class ForTest3 {
	public static void main(String[] args) {
		int dan = ((int)(Math.random()*8) + 1);; //1~9
		for (int num = 1; num <= 9; num++)
			System.out.print(dan + "x" + num + "=" + dan * num + "\t");
	}
}
