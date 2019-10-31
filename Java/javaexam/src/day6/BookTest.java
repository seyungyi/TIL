package day6;

class Book {
	String title;
	String author;
	int price;
	
	Book() {
		this("자바의 정석", "남궁성", 30000);
		/*
		title = "자바의 정석";
		author = "남궁성";
		price = 30000;
		*/
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		return "책이름 : " + title + ", 저자 : " + author + ", 가격 : " + price;
	}
}

public class BookTest {
	public static void main(String[] args) {
		Book bk[] = new Book[5];
		bk[0] = new Book();
		bk[1] = new Book("이것이 자바다", "신용권", 30000);
		bk[2] = new Book("Do it! HTML", "고경희", 28000);
		bk[3] = new Book("여행의 이유", "김영하", 13500);
		bk[4] = new Book("고요할수록 밝아지는 것들", "혜민", 15000);
		
		for(int i=0; i<bk.length; i++) 
			System.out.println(bk[i].getBookInfo());
	}
}
