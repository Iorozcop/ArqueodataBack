package com.arqueodata.ArqueodataBack.models.dao;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long>{
	
	/**
	 * Busca por nombre
	 * 
	 * @param nombre
	 * @return
	 */
	public Role findByNombre(String nombre);
}
