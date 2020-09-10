package com.baizhi.entity;

public class Address {
	private int id;
	private int uid;
	private String recvName;
	private String adrs;
	private String mobile;
	private int deleState;
	private int seleState;
	private User user;
	public Address(int id, int uid, String recvName, String adrs, String mobile, int deleState, int seleState,
			User user) {
		super();
		this.id = id;
		this.uid = uid;
		this.recvName = recvName;
		this.adrs = adrs;
		this.mobile = mobile;
		this.deleState = deleState;
		this.seleState = seleState;
		this.user = user;
	}
	public Address() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getDeleState() {
		return deleState;
	}
	public void setDeleState(int deleState) {
		this.deleState = deleState;
	}
	public int getSeleState() {
		return seleState;
	}
	public void setSeleState(int seleState) {
		this.seleState = seleState;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", adrs=" + adrs + ", mobile=" + mobile
				+ ", deleState=" + deleState + ", seleState=" + seleState + ", user=" + user + "]";
	}
	
}
