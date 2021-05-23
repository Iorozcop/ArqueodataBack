package com.arqueodata.ArqueodataBack.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;
import com.arqueodata.ArqueodataBack.models.services.IPiezaService;

import java.sql.Date;

import java.text.SimpleDateFormat;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PiezaRestController {
	
	@Autowired
	private IPiezaService piezaService;
	
	private final Logger log = LoggerFactory.getLogger(PiezaRestController.class);
	
	//MUESTRA TODAS LAS PIEZAS
	
	@GetMapping("/piezas")
	public List<Pieza> index(){
		return piezaService.findAll();
	}
	
	@GetMapping("/piezas/page/{page}")
	public Page<Pieza> index(@PathVariable Integer page){
		return piezaService.findAll(PageRequest.of(page, 6));
	}
	
	/* BUSCA POR ID */
	
	@GetMapping("/piezas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Pieza pieza = null;
		
		try {
			pieza = piezaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(pieza == null) {
			response.put("mensaje", "La pieza con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pieza>(pieza, HttpStatus.OK);
		
	}
	
	// BUSCA POR MÚLTIPLES CAMPOS
	
	@PostMapping("/piezas/search")
	public ResponseEntity<?> search(@RequestBody Pieza pieza){
		Map<String, Object> response = new HashMap<>();
		List<Pieza> listaPiezas = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		final Date fecha = pieza.getFecha();
		final Yacimiento yacimiento = pieza.getYacimiento();
		final Campain campain = pieza.getCampain();
		final String material = pieza.getMaterial();
		final String util = pieza.getUtil();
		
		try {
						
			listaPiezas = piezaService.buscaPieza(pieza);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al buscar en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(listaPiezas.size() == 0) {
			response.put("mensaje", "No existen resultados con esa búsqueda en la BBDD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Pieza>>(listaPiezas,HttpStatus.OK);
	}
	
	
	// CREA PIEZA
	
	@PostMapping("/piezas")
	public ResponseEntity<?> create(@Valid @RequestBody Pieza pieza, BindingResult result){
		Pieza nuevaPieza = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors= new ArrayList<>();
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo " + err.getField() + " " + err.getDefaultMessage());
			}
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			nuevaPieza = piezaService.save(pieza);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La pieza ha sido creada con éxito");
		response.put("pieza", nuevaPieza);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	// EDITA PIEZA
	
	@PutMapping("/piezas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Pieza pieza, BindingResult result, @PathVariable Long id) {
		Pieza piezaBBDD = piezaService.findById(id);
		Pieza piezaEditada = null;
		Map<String, Object> response = new HashMap<>();
		
		if(piezaBBDD == null) {
			response.put("mensaje", "Error: no se puede editar, la pieza con ID: ".concat(id.toString().concat(" no existe en la BBDD")));
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
			piezaBBDD.setCoordenadasX(pieza.getCoordenadasX());
			piezaBBDD.setCoordenadasY(pieza.getCoordenadasY());
			piezaBBDD.setCoordenadasZ(pieza.getCoordenadasZ());
			piezaBBDD.setCampain(pieza.getCampain());
			piezaBBDD.setYacimiento(pieza.getYacimiento());
			piezaBBDD.setEstado(pieza.getEstado());
			piezaBBDD.setFecha(pieza.getFecha());
			piezaBBDD.setFoto(pieza.getFoto());
			piezaBBDD.setMaterial(pieza.getMaterial());
			piezaBBDD.setObservaciones(pieza.getObservaciones());
			piezaBBDD.setUtil(pieza.getUtil());
			piezaBBDD.setZona(pieza.getZona());
			
			piezaEditada = piezaService.save(piezaBBDD);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la pieza en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La pieza ha sido editada con éxito");
		response.put("pieza", piezaEditada);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	// ELIMINA PIEZA
	
	@DeleteMapping("/piezas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			//elimina la foto de la pieza en el caso de que la pieza se elimine
			Pieza pieza = piezaService.findById(id);
			String nombreFotoAnterior = pieza.getFoto();
			
			if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior= Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				//convertimos esta ruta a un archivo
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()){
					archivoFotoAnterior.delete();
				}
			}
			
			piezaService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la pieza");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Pieza eliminada con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	//Permite ver la imagen subida en el navegador
	/* nombreFoto:.+ es una expresión regular que indica que el parámetro con el nombre de la foto
	viene acompañada de una extensión .jpg por ejemplo */
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Path rutaArchivo= Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		log.info(rutaArchivo.toString());
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() || !recurso.isReadable()){
			rutaArchivo= Paths.get("src/main/resources/static/images").resolve("logoarqueodata.jpg").toAbsolutePath();
			try {
				recurso = new UrlResource(rutaArchivo.toUri());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			log.error("No se pudo cargar la imágen: " + nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
//		cabecera.add(HttpHeaders.CONTENT_TYPE,"image/*");
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		//recurso es la imagen, cebecera es para forzar la descarga y el status
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	// SUBIDA DE IMÁGEN
	
	@PostMapping("/piezas/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		Pieza pieza = piezaService.findById(id);
		
		if(!archivo.isEmpty()) {
			//con UUID controlamos que el nombre de foto que entra sea único para que no genere conflictos
			String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			log.info(rutaArchivo.toString());
			//copy mueve el archivo que hemos subido al servidor a la ruta escogida
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
					
			pieza.setFoto(nombreArchivo);
			piezaService.save(pieza);
			
			response.put("pieza", pieza);
		}
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
		
}
