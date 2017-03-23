package com.signhor.cms.model;


public class Keyword implements Comparable<Keyword>{
	private int id;
	/**
	 * 关键字的名称
	 */
	private String name;
	/**
	 * 被引用的次数
	 */
	private int times;
	/**
	 * 关键字的全拼
	 */
	private String nameFullPy;
	/**
	 * 关键字的�?�?
	 */
	private String nameShortPy;
	
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
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	public String getNameFullPy() {
		return nameFullPy;
	}
	public void setNameFullPy(String nameFullPy) {
		this.nameFullPy = nameFullPy;
	}
	
	public String getNameShortPy() {
		return nameShortPy;
	}
	public void setNameShortPy(String nameShortPy) {
		this.nameShortPy = nameShortPy;
	}
	
	public Keyword() {
	}
	public Keyword(String name, int times) {
		super();
		this.name = name;
		this.times = times;
	}
	
	public Keyword(int id,String name, int times) {
		super();
		this.id = id;
		this.name = name;
		this.times = times;
	}
	public Keyword(int id,String name,String nameFullPy,String nameShortPy) {
		super();
		this.id = id;
		this.name = name;
		this.nameShortPy = nameShortPy;
		this.nameFullPy = nameFullPy;
	}
	public Keyword(int id,String name,int times, String nameFullPy,String nameShortPy) {
		super();
		this.id = id;
		this.name = name;
		this.times = times;
		this.nameShortPy = nameShortPy;
		this.nameFullPy = nameFullPy;
	}
	@Override
	public int compareTo(Keyword o) {
		return this.times>o.times?-1:(this.times==o.times?0:1);
	}
	
}
