package com.example.jeongyeji.myapplication.com.dto;

import java.sql.Timestamp;

public class BBS_DTO {
	private int bbs_no;
	private String user_id;
	private Timestamp bbs_date;
	private String bbs_title;
	private String bbs_content;
	private String bbs_location;
	private int bbs_read;
	public int getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(int bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(Timestamp bbs_date) {
		this.bbs_date = bbs_date;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getBbs_content() {
		return bbs_content;
	}
	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}
	public int getBbs_read() {
		return bbs_read;
	}
	public void setBbs_read(int bbs_read) {
		this.bbs_read = bbs_read;
	}
	public void setBbs_location(String bbs_location){this.bbs_location=bbs_location;}
	public String getBbs_location(){return bbs_location;}
}
