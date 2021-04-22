package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, length=20)
	private String nombre;
	
	
	//GETTER ANDS SETTER

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
	 * @return the email
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param email the email to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;
}

