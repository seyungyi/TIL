package day3;

public class ArrayLab2 {
	public static void main(String[] args) {
		char[] c = new char[] {'J', 'a', 'v', 'a'};
		for(int i=0; i<c.length; i++) {
			if(c[i] > 64 && c[i] < 97) {
				c[i] += 32;
			} else {
				c[i] -= 32;
			}
			if( i == c.length-1 ) {
				System.out.println(c[i]);
			} else {
				System.out.print(c[i] + ", ");
			}
		}
	}
}
