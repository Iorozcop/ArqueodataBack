package com.arqueodata.ArqueodataBack.models.services;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arqueodata.ArqueodataBack.models.entity.Usuario;

public interface IUsuarioService {

	/**
	 * Muestra todos los usuarios
	 * 
	 * @return
	 */
	public List<Usuario> findAll();
	
	/**
	 * Muestra todos los usuarios con paginación
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Usuario> findAll(Pageable pageable);
	
	/**
	 * Busca por nombre de usuario
	 * 
	 * @param username
	 * @return
	 */
	public Usuario findByUsername(String username);
	
	/**
	 * Busca usuario por id
	 * 
	 * @param id
	 * @return
	 */
	public Usuario findById(Long id);
	
	/**
	 * Guarda usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario save(Usuario usuario);
	
	/**
	 * Elimina usuario
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
}
