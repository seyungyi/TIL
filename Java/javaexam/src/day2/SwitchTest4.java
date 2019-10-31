package day2;

//if 문을 사용하여 점수가
// 90 ~ 100 점이면 A등급
// 80 ~ 89 점이면 B등급
// 70~79 점이면 C등급
// 60~69 점이면 D등급
// 0~59 점이면 F등급

public class SwitchTest4 {
	public static void main(String[] args) {
		int score = (int)(Math.random() * 101); // 0~100
		//System.out.println(score);
		String grade;
		switch (score/10) {
		case 10 :
		case 9 : 
			grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7 :
			grade = "C";
			break;
		case 6 :
			grade = "D";
			break;
		default :
			grade = "F";
		}
		System.out.println(score + "점은 " + grade + " 등급");
	}
}
