package com.arqueodata.ArqueodataBack.models.services;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IUsuarioDao;
import com.arqueodata.ArqueodataBack.models.entity.Usuario;


@Service
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService{

	// Registra los errores
	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioDao.findAll(pageable);
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

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null){
			logger.error("Error al iniciar sesi??n. No existe el usuario '"+username+"' en la base de datos");
			throw new UsernameNotFoundException("Error al iniciar sesi??n. No existe el usuario '"+username+"' en la base de datos");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

}
