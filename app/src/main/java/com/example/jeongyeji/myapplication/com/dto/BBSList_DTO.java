package com.example.jeongyeji.myapplication.com.dto;

import java.util.ArrayList;

public class BBSList_DTO {
	int codenum;
	ArrayList<BBS_DTO> bbsList;
	public int getCodenum() {
		return codenum;
	}
	public void setCodenum(int codenum) {
		this.codenum = codenum;
	}
	public ArrayList<BBS_DTO> getBbsList() {
		return bbsList;
	}
	public void setBbsList(ArrayList<BBS_DTO> bbsList) {
		this.bbsList = bbsList;
	}
	
}
