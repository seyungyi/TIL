package day4;

public class LottoMachine1 {
	public static void main(String[] args) {
		int num[] = new int[6];
		
//		boolean check = false;
//		int count=0;
//		
//		while(count<6) {
//			int random = (int)(Math.random() * 45) + 1;
//			for(int i=0; i<count; i++) {
//				if(num[i] == random) {
//					check = true;
//					break;
//				}
//			}
//			if(check) {
//				check = false;
//			} else {
//				num[count] = random;
//				count++;
//			}
//		}
//		
//		for(int i=0; i<num.length; i++) {
//			if(i == num.length-1) {
//				System.out.println(num[i]);
//			} else {
//				System.out.print(num[i] + ", ");
//			}
//		}
		
		
//		for(int i=0; i<num.length; i++) {
//			num[i] = (int)(Math.random() * 45) + 1;
//			for(int j=0; j<=i-1; j++) {
//				if(num[i] == num[j]) {
//					i--;
//					break;
//				}
//			}
//		}
		
		for(int i=0; i<num.length; i++) {
			int temp = (int)(Math.random() * 45) + 1;
			num[i] = temp;
			for(int j=0; j<i; j++) {
					if(num[i] == num[j]) {
						num[i] = temp;
						i--;
				}
			}
		}
		
		for(int i=0; i<num.length; i++) {	
			if(i == num.length-1) {
				System.out.println(num[i]);
			} else {
				System.out.print(num[i] + ", ");
			}
		}
	}
}
