package day5;

public class MethodLab1 {
	public static void main(String[] args) {
		NumRepeat('@', 3);
		NumRepeat('%', 4);
		NumRepeat('A', 5);
		NumRepeat('D', 3);		
	}
	static void NumRepeat(char word, int num) {
		for(int i=0; i<num; i++) {
			System.out.printf("%c", word);
		}
		System.out.println();
	}
}
