package model.vo;

public class MeetingVO {
	private String name;
	private String title;
	private int id; 
	private String meetingDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "MeetingVO [name=" + name + ", title=" + title + ", id=" + id + ", meetingDate=" + meetingDate + "]";
	}
}
