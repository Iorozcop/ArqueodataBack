package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table (name="piezas")
public class Pieza implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date fecha;
	
	@NotNull(message="el yacimiento no puede estar vacío")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="yacimiento_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//para ignorar al generar el json unos atributos que se crean por defecto con el FetchType.LAZY
	private Yacimiento yacimiento;
	
	@NotNull(message="la campaña no puede estar vacía")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="campain_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Campain campain;
	 
	private String material;
	 
	private String util;
	
	@Column(nullable = false)
	private int coordenadasX;
	
	@Column(nullable = false)
	private int coordenadasY;
	
	@Column(nullable = false)
	private int coordenadasZ;
	
	@Column(nullable = false)
	private String zona;
	 
	private String estado;
	 	 
	private String observaciones;
	 
	private String foto;
	
	

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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param date the fecha to set
	 */
	public void setFecha(Date date) {
		this.fecha = date;
	}
	
	/**
	 * @return the yacimiento
	 */
	public Yacimiento getYacimiento() {
		return yacimiento;
	}

	/**
	 * @param yacimiento the yacimiento to set
	 */
	public void setYacimiento(Yacimiento yacimiento) {
		this.yacimiento = yacimiento;
	}
	 
	/**
	 * @return the campain
	 */
	public Campain getCampain() {
		return campain;
	}

	/**
	 * @param campain the campain to set
	 */
	public void setCampain(Campain campain) {
		this.campain = campain;
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
	public int getCoordenadasX() {
		return coordenadasX;
	}

	/**
	 * @param coordenadasX the coordenadasX to set
	 */
	public void setCoordenadasX(int coordenadasX) {
		this.coordenadasX = coordenadasX;
	}

	/**
	 * @return the coordenadasY
	 */
	public int getCoordenadasY() {
		return coordenadasY;
	}

	/**
	 * @param coordenadasY the coordenadasY to set
	 */
	public void setCoordenadasY(int coordenadasY) {
		this.coordenadasY = coordenadasY;
	}

	/**
	 * @return the coordenadasZ
	 */
	public int getCoordenadasZ() {
		return coordenadasZ;
	}

	/**
	 * @param coordenadasZ the coordenadasZ to set
	 */
	public void setCoordenadasZ(int coordenadasZ) {
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
	

	//SERIALIZABLE

	private static final long serialVersionUID = 1L;
	
}
