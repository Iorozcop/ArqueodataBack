package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IUsuarioDao;
import com.arqueodata.ArqueodataBack.models.entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
		//si lo encuentra retorna usuario, sino un null
		return usuarioDao.findById(id).orElse(null);
	}
		

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		//devuelve la entidad guardada
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

}
