package com.arqueodata.ArqueodataBack.models.dao;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	/**
	 * Busca por nombre de usuario
	 * 
	 * @param username
	 * @return
	 */
	public Usuario findByUsername(String username);
	
}
