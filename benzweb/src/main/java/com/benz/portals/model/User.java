package com.benz.portals.model;

import java.util.Date;

public class User {
	private int id;
	/**
	 * �û���¼����
	 */
	private String username;
	/**
	 * �û���¼����
	 */
	private String password;
	/**
	 * �û�����������
	 */
	private String nickname;
	/**
	 * �û����ʼ�
	 */
	private String email;
	/**
	 * �û�����ϵ�绰
	 */
	private String phone;
	/**
	 * �û���״̬��0��ʾͣ�ã�1��ʾ����
	 */
	private int status;
	
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	
	
	public User(int id, String username, String password, String nickname,
			String email, String phone, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}
	public User() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
