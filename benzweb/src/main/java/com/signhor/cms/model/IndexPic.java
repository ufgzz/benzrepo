package com.signhor.cms.model;

import java.util.Date;

/**
 * 首页宣传图片
 * @author Administrator
 *
 */
public class IndexPic {
	private int id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 子标�?
	 */
	private String subTitle;
	/**
	 * 首页的链接类型，如果�?0表示网内链接，只要链接到�?个文章节点中�?/topic/xx
	 * 如果�?1表示�?外的链接，需要指定完整的url路径
	 */
	private int linkType;
	/**
	 * 链接的地�?,如果是站内链接就用一个文章节点来表示
	 */
	private String linkUrl;
	/**
	 * 图片的新名称，使用当前时间的毫秒�?
	 */
	private String newName;
	/**
	 * 图片的原始名�?
	 */
	private String oldName;
	/**
	 * 图片的状态，0表示停用�?1表示启动
	 */
	private int status;
	/**
	 * 位置
	 */
	private int pos;
	private Date createDate;
	
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
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
	
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	public int getLinkType() {
		return linkType;
	}
	public void setLinkType(int linkType) {
		this.linkType = linkType;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
