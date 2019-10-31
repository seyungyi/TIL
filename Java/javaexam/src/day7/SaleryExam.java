package day7;

import day5.MethodLab3;

class SalaryExpr {
	private int bonus;
	
	SalaryExpr() {
		this(0);
	}
	
	SalaryExpr(int bonus) {
		this.bonus = bonus;
	}
	
	int getSalary(int grade) {
		if(grade == 1) {
			bonus += 100;
		} else if(grade == 2) {
			bonus += 90;
		} else if(grade == 3) {
			bonus += 80;
		} else {
			bonus += 70;
		}
		return bonus;
	}
}

public class SaleryExam {
	public static void main(String[] args) {
		int month = MethodLab3.getRandom(12);
		int grade = MethodLab3.getRandom(4);
		SalaryExpr sal;
		if(month % 2 == 0) {
			sal = new SalaryExpr(100);
		} else {
			sal = new SalaryExpr();
		}
		System.out.println(month + " 월 " + grade + " 등급의 월급은 " + sal.getSalary(grade) + " 입니다.");
	}
}
