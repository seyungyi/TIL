package day11;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapLab1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<5; i++) {
			String std = scn.next();
			int num = scn.nextInt();
			if(map.containsKey(std)) {
				continue;
			} else {
				map.put(std, num);
			}
		}
		System.out.print("입력된 데이터 : ");
		int count=0;
		Set<String> kset = map.keySet();
		for(String data : kset) {
			System.out.print(data + "(" + map.get(data) + ")");
			if(count < map.size()-1)
				System.out.print(", ");
			count++;
		}
		scn.close();
	}
}
