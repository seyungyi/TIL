package day10;

@SuppressWarnings("serial") // 내가 임의로 한것
class DuplicateException extends Exception {
    DuplicateException() {
    	super("중복된 로또 번호가 발생했습니다.");
    }
}
class LottoMachine {
	private int[] nums;
	LottoMachine() {
		nums = new int[6];
	}
	public void createLottoNum() {
		for(int i=0; i<nums.length; i++)
			nums[i] = (int)(Math.random()*20) + 1;
		/*
		 Random rnd = new Random(); // import 필수
		 for(int i=0; i<nums.length; i++)
			nums[i] = rnd.nextInt(20) + 1;
		 */
	}
	public void checkLottoNum() throws DuplicateException {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) {
					throw new DuplicateException();
				}				
			}
		}
	}
	public int[] getNums() {
		return nums;
	}
}

public class LottoGame {
	public static void main(String[] args) {
		LottoMachine lm = new LottoMachine();
		lm.createLottoNum();
		int arr[] = lm.getNums();
		try {
			lm.checkLottoNum();
			System.out.print("(");
			for(int i=0; i<arr.length; i++) {
				if(i == arr.length-1) {
					System.out.printf("%d)\n", arr[i]);
				} else {
					System.out.printf("%d, ", arr[i]);
				}
			}
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
			// return; main문에서 return 문은 JVM으로 돌아가는 것
		}
	}
}
