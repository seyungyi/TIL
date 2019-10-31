package day3;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] nums = new int[10];
		System.out.println(nums);
		System.out.println(nums[0]);
		System.out.println(nums[9]);
		System.out.println(nums.length);
		//System.out.println(nums[10]);
		
		int[] nums2 = new int[] {10,20,30,40,50};
		System.out.println(nums2);
		System.out.println(nums2[0]);
		System.out.println(nums2[4]);
		System.out.println(nums2.length);
		
		int[] nums3 = {100, 200, 300};
		System.out.println(nums3);
		System.out.println(nums3[0]);
		System.out.println(nums3[2]);
		System.out.println(nums3.length);
	}
}
