package com.arqueodata.ArqueodataBack.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.services.ICampainService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CampainRestController {
	
	@Autowired
	private ICampainService campainService;
	
	/* TRAE TODAS LAS CAMPAÑAS */
	
	@GetMapping("/piezas/campains")
	public List<Campain> index(){
		return campainService.findAll();
	}
	
	@GetMapping("/piezas/campains/page/{page}")
	public Page<Campain> index(@PathVariable Integer page){
		return campainService.findAll(PageRequest.of(page, 4));
	}
	
	/* BUSCA POR ID */
	
	@GetMapping("/piezas/campains/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Campain campain = null;
		
		try {
			campain = campainService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(campain == null) {
			response.put("mensaje", "La campaña con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Campain>(campain, HttpStatus.OK);
		
	}
	
	
	/* CREA CAMPAÑA */
	
	@PostMapping("/piezas/campains")
	public ResponseEntity<?> create(@Valid @RequestBody Campain campain, BindingResult result){
		Map<String, Object> response = new HashMap<>();
		Campain nuevaCampain = null;
		
		if(result.hasErrors()) {
			
			List<String> errors= new ArrayList<>();
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo " + err.getField() + " " + err.getDefaultMessage());
			}
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			nuevaCampain = campainService.save(campain);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La campaña ha sido creada con éxito");
		response.put("campain", nuevaCampain);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	/* EDITA CAMPAÑA */
	
	@PutMapping("/piezas/campains/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Campain campain, BindingResult result, @PathVariable Long id) {
		Campain campainBBDD = campainService.findById(id);
		Campain campainEditada = null;
		Map<String, Object> response = new HashMap<>();
		
		if(campainBBDD == null) {
			response.put("mensaje", "Error: no se puede editar, la campaña con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(result.hasErrors()) {
			
			List<String> errors= new ArrayList<>();
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo " + err.getField() + " " + err.getDefaultMessage());
			}
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			campainBBDD.setCampain(campain.getCampain());
			
			campainEditada = campainService.save(campainBBDD);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la campaña en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La campaña ha sido editada con éxito");
		response.put("campain", campainEditada);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/* ELIMINA CAMAPAÑA */
	
	@DeleteMapping("/piezas/campains/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			campainService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la campaña de la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La campaña ha sido eliminada con éxito");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}

}
