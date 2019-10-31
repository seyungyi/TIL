public class FirstApp {
	public static void main(String[] args) {
		int x = 123;
		int tmp = x;	// 12  1+2=3 12%3=0 ÇÏ»þµå	1+2+3=6 
		int result = 0;
		while(tmp != 0) {
			System.out.println(tmp % 10);
			result += tmp % 10;
			tmp /= 10;
		}		
		if(x % result == 0)
			System.out.println("ÇÏ»þµå");
		else 
			System.out.println("ÇÏ»þµå ¾Æ´Ï´Ù");
	}
}
