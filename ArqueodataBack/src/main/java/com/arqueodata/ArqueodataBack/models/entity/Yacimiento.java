package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="yacimientos")
public class Yacimiento implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="El nombre no puede estar vacío")
	@Size(min=2, max=30)
	@Column(nullable = false, unique = true)
	private String nombre;
	
	@NotNull(message="El lugar no puede estar vacío")
	@Size(min=2, max=30)
	@Column(nullable = false)
	private String lugar;
	
	private String epoca;
	
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}
	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	/**
	 * @return the epoca
	 */
	public String getEpoca() {
		return epoca;
	}
	/**
	 * @param epoca the epoca to set
	 */
	public void setEpoca(String epoca) {
		this.epoca = epoca;
	}
	
	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;

}
