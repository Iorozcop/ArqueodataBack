package com.arqueodata.ArqueodataBack.models.services;

import com.arqueodata.ArqueodataBack.models.entity.Role;


public interface IRoleService {

	//busca por nombre de usuario
		public Role findByNombre(String nombre);
}
