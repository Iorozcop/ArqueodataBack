package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Usuario;


public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	
}
