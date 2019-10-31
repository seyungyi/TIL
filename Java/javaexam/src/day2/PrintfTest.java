package day2;
public class PrintfTest {
	public static void main(String[] args) {
		System.out.printf("�׽�Ʈ�Դϴ�\n");	//%n	
		System.out.printf("%d %x %o %c\n", 100, 100, 100, 100);
		System.out.printf("%c %c %c %c\n", ' ', 'A', '!', '3');
		System.out.printf("%b\n", true);
		System.out.printf("%f %e\n", 100.0, 100.0);
		System.out.printf("%.2f\n", 123.5678);
		System.out.printf("|%s|\n", "�ڹ�");
		System.out.printf("|%10s|\n", "�ڹ�");
		System.out.printf("|%-10s|\n", "�ڹ�");
		System.out.printf("%,d��\n", 1000000);			
	}
}








