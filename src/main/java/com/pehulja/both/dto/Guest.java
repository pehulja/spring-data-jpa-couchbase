package com.pehulja.both.dto;


public class Guest {
	
	private int id;
	
	private String fio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", fio=" + fio + "]";
	}
	
}
