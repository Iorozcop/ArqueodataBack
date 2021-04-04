package com.arqueodata.ArqueodataBack.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true, length=20)
	private String username;
	
	@Column(nullable = false)
	private String email;
	
	@Column(length=60)
	private String password;
	
	private Boolean enabled;
	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name = "usuario_id")
	, inverseJoinColumns= @JoinColumn(name = "role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private List<Role> roles;
	
	
	//GETTER AND SETTER
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	/**
	 * @return the nombre
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setUsername(String nombre) {
		this.username = nombre;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pass
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * SERIALIZABLE
	 */
	private static final long serialVersionUID = 1L;
	
	

}
