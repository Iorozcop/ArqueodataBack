package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="piezas")
public class Pieza implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Date fecha;
	 
	private String material;
	 
	private String util;
	
	@Column(nullable = false)
	private Number coordenadasX;
	
	@Column(nullable = false)
	private Number coordenadasY;
	
	@Column(nullable = false)
	private Number coordenadasZ;
	
	@Column(nullable = false)
	private String zona;
	 
	private String estado;
	 	 
	private String observaciones;
	 
	private String foto;
	

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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}


	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}


	/**
	 * @return the util
	 */
	public String getUtil() {
		return util;
	}


	/**
	 * @param util the util to set
	 */
	public void setUtil(String util) {
		this.util = util;
	}


	/**
	 * @return the coordenadasX
	 */
	public Number getCoordenadasX() {
		return coordenadasX;
	}


	/**
	 * @param coordenadasX the coordenadasX to set
	 */
	public void setCoordenadasX(Number coordenadasX) {
		this.coordenadasX = coordenadasX;
	}


	/**
	 * @return the coordenadasY
	 */
	public Number getCoordenadasY() {
		return coordenadasY;
	}


	/**
	 * @param coordenadasY the coordenadasY to set
	 */
	public void setCoordenadasY(Number coordenadasY) {
		this.coordenadasY = coordenadasY;
	}


	/**
	 * @return the coordenadasZ
	 */
	public Number getCoordenadasZ() {
		return coordenadasZ;
	}


	/**
	 * @param coordenadasZ the coordenadasZ to set
	 */
	public void setCoordenadasZ(Number coordenadasZ) {
		this.coordenadasZ = coordenadasZ;
	}


	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}


	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}


	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}


	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;
	
}
