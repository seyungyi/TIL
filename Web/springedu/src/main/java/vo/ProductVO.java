package vo;

public class ProductVO {
	private int bananaNum;
	private int appleNum;
	private int hanrabongNum;
	public ProductVO() {
		this.bananaNum = 0;
		this.appleNum = 0;
		this.hanrabongNum = 0;
	}
	public int getBananaNum() {
		return bananaNum;
	}
	public void setBananaNum(int num) {
		this.bananaNum += num;
	}
	public int getAppleNum() {
		return appleNum;
	}
	public void setAppleNum(int num) {
		this.appleNum += num;
	}
	public int getHanrabongNum() {
		return hanrabongNum;
	}
	public void setHanrabongNum(int num) {
		this.hanrabongNum += num;
	}
	
}
