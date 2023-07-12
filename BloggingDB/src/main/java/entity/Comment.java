package entity;

public class Comment {
	int cid;
	String text;
	int topicid;
	String uid;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int cid, String text, int topicid, String uid) {
		super();
		this.cid = cid;
		this.text = text;
		this.topicid = topicid;
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	

}
