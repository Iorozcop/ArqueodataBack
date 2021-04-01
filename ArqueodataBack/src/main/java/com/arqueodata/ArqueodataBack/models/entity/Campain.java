package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="capains")
public class Campain implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private  Number campain;
	
	//GETTER AND SETTER
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the campain
	 */
	public Number getCampain() {
		return campain;
	}
	/**
	 * @param campain the campain to set
	 */
	public void setCampain(Number campain) {
		this.campain = campain;
		
	}
	
	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;
}