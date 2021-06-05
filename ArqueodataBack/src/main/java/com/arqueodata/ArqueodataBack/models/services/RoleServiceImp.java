package com.arqueodata.ArqueodataBack.models.services;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IRoleDao;
import com.arqueodata.ArqueodataBack.models.entity.Role;

@Service
public class RoleServiceImp implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	@Transactional(readOnly=true)
	public Role findByNombre(String nombre) {
		
		return roleDao.findByNombre(nombre);
	}

}
