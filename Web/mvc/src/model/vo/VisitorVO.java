package model.vo;

public class VisitorVO {
	private String name;
	private String writeDate;
	private String momo;
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getMomo() {
		return momo;
	}
	public void setMomo(String momo) {
		this.momo = momo;
	}
	@Override
	public String toString() {
		return "VisitorVO [name=" + name + ", writeDate=" + writeDate + ", momo=" + momo + "]";
	}
}
