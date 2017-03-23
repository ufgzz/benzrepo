package com.signhor.cms.model;

public class CmsLink {
	/**
	 * 超链接标�?
	 */
	private int id;
	/**
	 * 超链接的标题
	 */
	private String title;
	/**
	 * 超链接的url
	 */
	private String url;
	/**
	 * 超链接的类型
	 */
	private String type;
	/**
	 * 是否在新窗口中打�?�?0表示否，1表示�?
	 */
	private int newWin;
	/**
	 * 超链接的id，html的标签id
	 */
	private String urlId;
	/**
	 * 超链接的class，html的标签的class
	 */
	private String urlClass;
	/**
	 * 超链接的位置
	 */
	private int pos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getNewWin() {
		return newWin;
	}
	public void setNewWin(int newWin) {
		this.newWin = newWin;
	}
	
	public String getUrlId() {
		return urlId;
	}
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	public String getUrlClass() {
		return urlClass;
	}
	public void setUrlClass(String urlClass) {
		this.urlClass = urlClass;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
}
