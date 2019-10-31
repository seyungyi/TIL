package day11;

import java.util.HashSet;
import java.util.Random;

public class LottoSet {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Random rdm = new Random();
		while(hs.size() != 10) {
			hs.add(rdm.nextInt(21)+10);
		}
		System.out.println("오늘의 로또 번호 : " + hs.toString());
	}
}
