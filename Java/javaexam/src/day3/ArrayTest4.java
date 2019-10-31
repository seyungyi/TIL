package day3;

public class ArrayTest4 {
	public static void main(String[] args) {
		int[] ary = new int[5];
		int sum=0;
		for(int data : ary) {
			sum += data;
		}
		System.out.println("sum = " + sum);
		
		ary[0] = 11;
		ary[1] = 9;
		
		for(int i=0; i<ary.length; i++) {
			ary[i] *= 2;
		}
		for(int i=0; i<ary.length; i++) {
			if(i == ary.length-1) {
				System.out.println(ary[i]);
			} else {
				System.out.print(ary[i] + ", ");
			}
		}
	}
}
