package com.narendra.entity.parking;

import java.util.UUID;

public class Entry {
	private String id;
	private boolean isOperational;

	public Entry() {
		this.id = UUID.randomUUID().toString();
		this.isOperational = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOperational() {
		return isOperational;
	}

	public void setOperational(boolean operational) {
		isOperational = operational;
	}
}