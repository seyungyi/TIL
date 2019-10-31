package day3;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		int[] nums2 = new int[] {10,20,30,40,50};
			for(int i=0; i<nums2.length; i++) {
				System.out.print(nums2[i] + " ");
			}
			System.out.println();
		
			for(int i=nums2.length-1; i>=0; i--) {
				System.out.print(nums2[i] + " ");
			}
			System.out.println();
			
			// nums2가 참조하는 배열의 첫 번째 데이터값하고
			// 마지막 데이터 값을 덧셈하여 출력해 본다.
			
			System.out.printf("nums2[0] + nums2[%d] = %d\n", nums2.length-1, nums2[0]+nums2[nums2.length-1]);
			
			// nums2 참조하는 배열의 첫번째, 세번째, 다섯번째 데이터를
			// 출력하는 for문을 작성하기
			
			for(int i=0; i<nums2.length; i+=2) {
				System.out.println(nums2[i]);
			}
	}
}
