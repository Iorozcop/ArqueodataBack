package com.arqueodata.ArqueodataBack.models.services;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import com.arqueodata.ArqueodataBack.models.entity.Role;


public interface IRoleService {

	/**
	 * Busca por nombre de usuario
	 * 
	 * @param nombre
	 * @return
	 */
	public Role findByNombre(String nombre);
}
