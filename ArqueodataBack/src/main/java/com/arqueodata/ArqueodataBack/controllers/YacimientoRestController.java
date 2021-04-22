package com.arqueodata.ArqueodataBack.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;
import com.arqueodata.ArqueodataBack.models.services.IYacimientoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class YacimientoRestController {

	@Autowired
	private IYacimientoService yacimientoService;
	
	/* TRAE TODOS LOS YACIMIENTOS */
	
	@GetMapping("/piezas/yacimientos")
	public List<Yacimiento> index(){
		return yacimientoService.findAll();
	}
	
	/*BUSCA POR ID*/
	
	@GetMapping("/piezas/yacimientos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Yacimiento yacimiento = null;
		
		try {
			yacimiento = yacimientoService.findById(id);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(yacimiento == null) {
			response.put("mensaje", "El yacimiento con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Yacimiento>(yacimiento, HttpStatus.OK);
	}
	
	
	/* CREA YACIMIENTO */
	
	@PostMapping("/piezas/yacimientos")
	public ResponseEntity<?> create(@RequestBody Yacimiento yacimiento){
		Map<String, Object> response = new HashMap<>();
		Yacimiento nuevoYacimiento = null;
		
		try {
			
			nuevoYacimiento = yacimientoService.save(yacimiento);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El yacimiento ha sido creado con éxito");
		response.put("yacimiento", nuevoYacimiento);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	/* EDITA YACIMIENTO */
	
	@PutMapping("/piezas/yacimientos/{id}")
	public ResponseEntity<?> update(@RequestBody Yacimiento yacimiento, @PathVariable Long id) {
		Yacimiento yacimientoBBDD = yacimientoService.findById(id);
		Yacimiento yacimientoEditado = null;
		Map<String, Object> response = new HashMap<>();
		
		if(yacimientoBBDD == null) {
			response.put("mensaje", "Error: no se puede editar, el yacimiento con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			yacimientoBBDD.setNombre(yacimiento.getNombre());
			yacimientoBBDD.setLugar(yacimiento.getLugar());
			yacimientoBBDD.setEpoca(yacimiento.getEpoca());
			
			yacimientoEditado = yacimientoService.save(yacimientoBBDD);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el yacimiento en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El yacimiento ha sido editado con éxito");
		response.put("yacimiento", yacimientoEditado);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/* ELIMINA YACIMIENTO */
	
	@DeleteMapping("/piezas/yacimientos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
	try {
			yacimientoService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el yacimiento de la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El yacimiento ha sido eliminado con éxito");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
