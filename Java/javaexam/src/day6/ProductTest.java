package day6;

public class ProductTest {
	public static void main(String[] args) {
		Product[] pd = new Product[5];
		pd[0] = new Product();
		pd[1] = new Product("강아지인형", 3, 12000);
		pd[2] = new Product("고양이인형", 1, 9000);
		pd[3] = new Product("반달곰인형", 2, 16000);
		pd[4] = new Product("호랑이인형", 6, 20000);
		
		for(int i=0; i<pd.length; i++) {
			System.out.print("상품이름 : " + pd[i].getName() + ", 재고량 : " + 
					pd[i].getBalance() + ", 금액 : ");
			System.out.printf("%,d원\n", pd[i].getPrice());
		}
	}
}
