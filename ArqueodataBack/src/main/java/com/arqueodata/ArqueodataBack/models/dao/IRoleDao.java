package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long>{
	
	public Role findByNombre(String nombre);
}
