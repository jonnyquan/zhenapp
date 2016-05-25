package com.zhenapp.po.Custom;

import com.zhenapp.po.TNoteInfo;

public class TNoteInfoCustom extends TNoteInfo{
	private String notetext;
	private String notestatename;
	

	public String getNotestatename() {
		return notestatename;
	}

	public void setNotestatename(String notestatename) {
		this.notestatename = notestatename;
	}

	public String getNotetext() {
		return notetext;
	}

	public void setNotetext(String notetext) {
		this.notetext = notetext;
	}
	
}
