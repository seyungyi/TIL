package day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapLab2 {
	public static void main(String[] args) {
		HashMap<String, Integer> nations = 	new HashMap<String, Integer>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(nations.size()<5) {
			nations.put(sc.next(), sc.nextInt());
		}
		
		System.out.print("입력된 데이터 : ");
		
		 Iterator<String> iterator = nations.keySet().iterator();
		    while (iterator.hasNext()) {
		        String key = iterator.next();
		        
		        if(iterator.hasNext())
		        	System.out.print(key+"(" +nations.get(key)+"), " );
		        else
		        	System.out.print(key+"(" +nations.get(key)+")" );
		    }
	}
}
