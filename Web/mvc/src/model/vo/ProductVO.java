package model.vo;

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
	public void setBananaNum() {
		this.bananaNum++;
	}
	public int getAppleNum() {
		return appleNum;
	}
	public void setAppleNum() {
		this.appleNum++;
	}
	public int getHanrabongNum() {
		return hanrabongNum;
	}
	public void setHanrabongNum() {
		this.hanrabongNum++;
	}
	
}
