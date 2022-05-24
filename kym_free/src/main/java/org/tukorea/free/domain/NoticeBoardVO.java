package org.tukorea.free.domain;

import java.sql.Date;

public class NoticeBoardVO {
	private int num;
	private String id;
	private String username;
	private String title;
	private String Content;
	private String major;
	private Date date;
	private String sex;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "NoticeBoardVO [num=" + num + ", id=" + id + ", username=" + username + ", title=" + title + ", Content="
				+ Content + ", major=" + major + ", date=" + date + ", sex=" + sex + "]";
	}
	
}
