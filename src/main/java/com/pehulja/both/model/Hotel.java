package com.pehulja.both.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Entity
@Table(name = "hotel")
@Document
public class Hotel {
	@javax.persistence.Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Field
	@Column(name = "name")
	private String name;

	@Field
	@OneToMany(mappedBy = "hotel", cascade=CascadeType.ALL)
	private List<Room> rooms;

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
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", rooms=" + rooms + "]";
	}
}