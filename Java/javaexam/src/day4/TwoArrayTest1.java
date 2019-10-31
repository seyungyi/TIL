package day4;
public class TwoArrayTest1 {
	public static void main(String[] args) {		
		int nums[][] = new int[3][4];
		System.out.println(nums);
		System.out.println(nums[0]);
		System.out.println(nums[0][0]);
		System.out.println(nums.length);
		System.out.println(nums[0].length);
		
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums[row].length; col++) {
			System.out.println(nums[row][col] + " ");	
			}
			System.out.println();
		}
		
		for(int[] rowData : nums) {
			for(int data : rowData) {
				System.out.println(data + " ");
			}
			System.out.println();
		}
	}
}
