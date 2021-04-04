package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import com.arqueodata.ArqueodataBack.models.entity.Usuario;

public interface IUsuarioService {

	//muestra todos los usuarios
	public List<Usuario> findAll();
	
	//busca por nombre de usuario
	public Usuario findByUsername(String username);
	
	//busca usuario por id
	public Usuario findById(Long id);
	
	//guarda usuario
	public Usuario save(Usuario usuario);
	
	//elimina usuario
	public void delete(Long id);
	

	
}
