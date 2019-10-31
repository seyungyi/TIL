package day1;

//if 문을 사용하여 점수가
// 90 ~ 100 점이면 A등급
// 80 ~ 89 점이면 B등급
// 70~79 점이면 C등급
// 60~69 점이면 D등급
// 0~59 점이면 F등급

public class IfTest4 {
	public static void main(String[] args) {
		int score = (int)(Math.random() * 101); // 0~100
		if (score <= 59)
			System.out.println(score + "점은 F 등급");
		else if (score <= 69)
			System.out.println(score + "점은 D 등급");
		else if (score <= 79)
			System.out.println(score + "점은 C 등급");
		else if (score <= 89)
			System.out.println(score + "점은 B 등급");
		else
			System.out.println(score + "점은 A 등급");
	}
}
