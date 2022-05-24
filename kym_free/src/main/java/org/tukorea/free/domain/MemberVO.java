package org.tukorea.free.domain;

public class MemberVO {
	private String id;
	private String passwd;
	private String username;
	private String major;
	private int age;
	private String sex;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", username=" + username + ", major=" + major + ", age="
				+ age + ", sex=" + sex + "]";
	}
}
