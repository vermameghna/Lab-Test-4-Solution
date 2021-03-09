package com.bookapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;

	public Publisher() {}	
	public Publisher(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public Publisher(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Publisher [id=").append(id).append(", code=").append(code).append(", name=").append(name)
				.append("]");
		return builder.toString();
	}

}
