package day12;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		int array[] = {3, 4, 2, 5, 2, 3, 6, 7, 5, 7, 9};
		CreateList cl = new CreateList();
		ArrayList<Integer> newArr = new ArrayList<>();
		// ArrayList<Integer> newArr = new CreateList().convertList(array);
		newArr = cl.convertList(array);
		for(int data : newArr)
			System.out.println(data);
	}
}

class CreateList {
	ArrayList<Integer> convertList(int array[]) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();
//		for(int i=0; i<array.length; i++) {
//			newArr.add(new Integer(array[i]));
//		}
		int count=array.length;		
		for(int i=0; i<count; i++) {
			newArr.add(new Integer(array[count - i - 1]));
		}
		return newArr;	
	}
}