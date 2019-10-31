package test;
public class GoodsTest {
	public static void main(String[] args) {
		// "PRD-0001", "듀크컴퓨터", 10000, 'N' 으로 객체 생성
		// "PRD-0002", "턱시컴퓨터", 20000 으로 객체 생성
        // 생성된 객체 각각 getGoodsInfo()를 호출하고 리턴결과를 출력합니다.
		Goods[] gs = new Goods[2];
		gs[0] = new Goods("PRD-0001", "듀크컴퓨터", 10000, 'N');
		gs[1] = new Goods("PRD-0002", "턱시컴퓨터", 20000);
		for(Goods data : gs)
			System.out.println(data.getGoodsInfo());
	}
}
// 결과값
// 상품ID : PRD-0001, 상품명 : 듀크컴퓨터, 가격 : 10,000원, AS가능여부 : 불가
// 상품ID : PRD-0002, 상품명 : 턱시컴퓨터, 가격 : 20,000원, AS가능여부 : 가능
