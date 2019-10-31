package day4;

public class TwoArrayLab1 {
	public static void main(String[] args) {
		char[][] arr = {
				{'B', 'C', 'A', 'A' },
				{'C', 'C', 'B', 'B' },
				{'D', 'A', 'A', 'D' }
		};
		char c = 'A';
		int[] num = new int[4];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 'A') {
					num[0]++;
				} else if(arr[i][j] == 'B') {
					num[1]++;
				} else if(arr[i][j] == 'C') {
					num[2]++;
				} else {
					num[3]++;
				}
			}
			
		}
		for(int i=0; i<num.length; i++) {
			System.out.println(c + "는 " + num[i] + "개 입니다.");
			c++;
		}
//		for(int i=0; i<num.length; i++) {
//			System.out.println((char)(i+65) + "는 " + num[i] + "개 입니다.");
//		}
	}
}
