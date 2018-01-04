package com.dingrui.gaofei.bean;

public class Manage {
	
	 private int man_id;
	 private String man_board;
	 private String man_client;
	 private String man_model;
	 private String man_bom;
	 private String man_flash;
	 private String man_cam;
	 private String man_lcm;
	 private int man_amou;
	 private String man_rem;
	 private int man_number;
	 private String man_user;
	 private String submission;
	
	 public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manage(int man_id, String man_board, String man_client,
			String man_model, String man_bom, String man_flash, String man_cam,
			String man_lcm, int man_amou, String man_rem, int man_number,
			String man_user, String submission) {
		super();
		this.man_id = man_id;
		this.man_board = man_board;
		this.man_client = man_client;
		this.man_model = man_model;
		this.man_bom = man_bom;
		this.man_flash = man_flash;
		this.man_cam = man_cam;
		this.man_lcm = man_lcm;
		this.man_amou = man_amou;
		this.man_rem = man_rem;
		this.man_number = man_number;
		this.man_user = man_user;
		this.submission = submission;
	}	
	
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}
	public String getMan_board() {
		return man_board;
	}
	public void setMan_board(String man_board) {
		this.man_board = man_board;
	}
	public String getMan_client() {
		return man_client;
	}
	public void setMan_client(String man_client) {
		this.man_client = man_client;
	}
	public String getMan_model() {
		return man_model;
	}
	public void setMan_model(String man_model) {
		this.man_model = man_model;
	}
	public String getMan_bom() {
		return man_bom;
	}
	public void setMan_bom(String man_bom) {
		this.man_bom = man_bom;
	}
	public String getMan_flash() {
		return man_flash;
	}
	public void setMan_flash(String man_flash) {
		this.man_flash = man_flash;
	}
	public String getMan_cam() {
		return man_cam;
	}
	public void setMan_cam(String man_cam) {
		this.man_cam = man_cam;
	}
	public String getMan_lcm() {
		return man_lcm;
	}
	public void setMan_lcm(String man_lcm) {
		this.man_lcm = man_lcm;
	}
	public int getMan_amou() {
		return man_amou;
	}
	public void setMan_amou(int man_amou) {
		this.man_amou = man_amou;
	}
	public String getMan_rem() {
		return man_rem;
	}
	public void setMan_rem(String man_rem) {
		this.man_rem = man_rem;
	}
	public int getMan_number() {
		return man_number;
	}
	public void setMan_number(int man_number) {
		this.man_number = man_number;
	}
	public String getMan_user() {
		return man_user;
	}
	public void setMan_user(String man_user) {
		this.man_user = man_user;
	}
	public String getSubmission() {
		return submission;
	}
	public void setSubmission(String submission) {
		this.submission = submission;
	}

}
