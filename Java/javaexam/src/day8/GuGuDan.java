package day8;

import day5.MethodLab3;

class Multiplication {
	private int dan;
	private int number;
	Multiplication() {}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication {
	GuGuDanExpr() {}
	GuGuDanExpr(int dan) {
		super(dan);
	}
	GuGuDanExpr(int dan, int number) {
		super(dan, number);
	}
	static void printAll() {
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d * %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}
	}
}

public class GuGuDan {
	public static void main(String[] args) {
		int dan = MethodLab3.getRandom(20);
		int number = MethodLab3.getRandom(20);
		System.out.println("dan °ª : " + dan + ", number °ª : " + number);
		GuGuDanExpr gd;		
		if((dan > 0 && dan < 10) && (number > 0 && number < 10)) {
			gd = new GuGuDanExpr(dan, number);
			System.out.print(dan + " * " + number + " = ");
			gd.printPart();
		} else if((dan > 0 && dan < 10) && number >= 10) {
			gd = new GuGuDanExpr(dan);
			System.out.print(dan + "´Ü :");
			gd.printPart();
		} else {
			GuGuDanExpr.printAll();
		}
		
	}
}
