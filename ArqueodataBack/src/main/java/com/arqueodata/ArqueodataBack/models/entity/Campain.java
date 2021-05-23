package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="campains")
public class Campain implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message=" no puede estar vacío")
	@Column(nullable = false,unique = true)
	private int campain;
	
	//GETTER AND SETTER
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the campain
	 */
	public int getCampain() {
		return campain;
	}
	/**
	 * @param campain the campain to set
	 */
	public void setCampain(int campain) {
		this.campain = campain;
		
	}
	
	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;
}