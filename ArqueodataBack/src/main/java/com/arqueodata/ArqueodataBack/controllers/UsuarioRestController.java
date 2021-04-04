package com.arqueodata.ArqueodataBack.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.arqueodata.ArqueodataBack.models.entity.Role;
import com.arqueodata.ArqueodataBack.models.entity.Usuario;
import com.arqueodata.ArqueodataBack.models.services.IRoleService;
import com.arqueodata.ArqueodataBack.models.services.IUsuarioService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/* TRAE TODOS LOS USUARIOS */
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	/* BUSCA POR ID */
	
	//ResponseEntity es una clase que propone spring para poder usarla en el manejo de errores
	//Se pone el tipo de dato generico <?> porque puede llegarte un conjunto de errores, un string, 
	//un objeto...etc. Es como el tipo any de typescript
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		//creamos nuestro propio responseEntity para manejar el error
		//creamos un map para tener un listado de errores asociados a un mensaje
		//Map es la interfaz, HashMap la implementaciín
		Map<String, Object> response = new HashMap<>();
		
		Usuario usuario = null;
		
		//DataAccessException es para manejar los errores que llegan de la BBDD
		try {
			usuario = usuarioService.findById(id);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la BBDD");
			//especificamos también el error concreto
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(usuario == null) {
			response.put("mensaje", "El usuario con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		//le pasamos por parametro la entidad y como segundo el status que en este caso es un 200
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	/* CREA USUARIO */
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		
		String passBcrypt = passwordEncoder.encode(usuario.getPassword());
		Role role = roleService.findByNombre("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		usuario.setRoles(roles);
		usuario.setEnabled(true);
		usuario.setPassword(passBcrypt);
		
		Usuario nuevoUsuario = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			nuevoUsuario = usuarioService.save(usuario);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//vamos a retornar un map con un mensaje de éxito y el usuario
		response.put("mensaje", "El usuario ha sido creado con éxito");
		response.put("usuario", nuevoUsuario);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	/* EDITA USUARIO */
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		Usuario usuarioBBDD = usuarioService.findById(id);
		Usuario usuarioEditado = null;
		Map<String, Object> response = new HashMap<>();
		
		if(usuarioBBDD == null) {
			response.put("mensaje", "Error: no se puede editar, el usuario con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
		
			usuarioBBDD.setEmail(usuario.getEmail());
			usuarioBBDD.setUsername(usuario.getUsername());
			usuarioBBDD.setRoles(usuario.getRoles());
			
			usuarioEditado = usuarioService.save(usuarioBBDD);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido editado con éxito");
		response.put("usuario", usuarioEditado);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	/* ELIMINA USUARIO */
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			usuarioService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuario de la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido eliminado con éxito");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	
}
