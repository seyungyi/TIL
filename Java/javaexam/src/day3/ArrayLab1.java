package day3;

public class ArrayLab1 {
	public static void main(String[] args) {
		int sum=0;
		int num[] = new int[10];
		System.out.print("모든 원소의 값 : ");		
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 17) + 4;
			if( i == num.length-1 ) {				
				System.out.println(num[i]);
			} else {
				System.out.print(num[i] + ", ");
			}
			sum += num[i];
			/*
			 * for(int data : num) { sum += data; }
			 */
		}		
		System.out.println("모든 원소의 합 : " + sum);
	}
}