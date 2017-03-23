package com.signhor.cms.model.commonlink;

public class Commonlink {
	/**
	 * 超链接标�?
	 */
	private String id;
	/**
	 * 超链接的标题
	 */
	private String name;
	/**
	 * 超链接的url
	 */
	private String url;
	/**
	 * 超链接的类型
	 */
	private String typeId;
	/**
	 * 是否在新窗口中打�?�?0表示否，1表示�?
	 */
	private int newWin;

	/**
	 * 排序id
	 */
	private int orderId;

	/**
	 * 公共连接创建时间
	 */
	private String createDate;

	/**
	 * 公共连接�?后修改时�?
	 */
	private String lastmodifyDate;

	/**
	 * 连接显示位置(界面显示位置)
	 */
	private int position;

	/**
	 * 用戶id
	 */
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getNewWin() {
		return newWin;
	}

	public void setNewWin(int newWin) {
		this.newWin = newWin;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastmodifyDate() {
		return lastmodifyDate;
	}

	public void setLastmodifyDate(String lastmodifyDate) {
		this.lastmodifyDate = lastmodifyDate;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
