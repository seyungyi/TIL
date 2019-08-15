package vo;

public class PidVO {
	private String name;
	private int count;
	public PidVO() {}
	public PidVO(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PidVO [name=" + name + ", count=" + count + "]";
	}
	
	
}
