package day9;
class SaleTV extends TV {
	private int price;
	SaleTV() {}
	SaleTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void play() {
		System.out.printf("판매TV 채널 %d번의 프로를 플레이 합니다.\n", getChannel());
	}
	public void sale() {
		System.out.printf("%s 모델의 상품을 판매합니다. %,d원을 지불해 주세요.\n", getModel(), getPrice());
	}
	public String toString() {
		return String.format("판매상품정보 : 모델명(%s), 가격(%,d), 크기(%d)\n", getModel(), getPrice(), getSize());
	}
}
class RentalTV extends TV implements Rentable {
	private int price;
	RentalTV() {}
	RentalTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void play() {
		System.out.printf("대여TV 채널 %d번의 프로를 플레이 합니다.\n", getChannel());
	}
	public void rent() {
		System.out.printf("%s 모델의 상품을 대여합니다. %,d원을 지불해 주세요.\n", getModel(), getPrice());
	}
	public String toString() {
		return String.format("대여상품정보 : 모델명(%s), 가격(%,d), 크기(%d)\n", getModel(), getPrice(), getSize());
	}
}

public class TVTest {
	public static void main(String[] args) {
		TV st = new SaleTV(300000, "SALETV-1", 40, 1);
		TV rt = new RentalTV(100000, "RENTALTV-10", 42, 1);
		st.channelUp();
		st.channelUp();
		rt.channelDown();
		rt.channelDown();
		rt.channelDown();
		printAllTV(st);
		printAllTV(rt);
		printRentalTV((Rentable)rt);		
	}
	static void printAllTV(TV tv) {
		System.out.print(tv.toString());
		if(tv instanceof SaleTV) {
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
		} else {
			((RentalTV)tv).play();
		}
	}
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}
}
