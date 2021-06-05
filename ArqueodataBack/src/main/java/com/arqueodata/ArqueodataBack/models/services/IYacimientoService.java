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
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IYacimientoService {

	/**
	 * Muestra todos los yacimientos 
	 * 
	 * @return
	 */
	public List<Yacimiento> findAll();
	
	/**
	 * Muestra todos los yacimientos con paginación
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Yacimiento> findAll(Pageable pageable);
	
	/**
	 * Busca yacimiento por id
	 * 
	 * @param id
	 * @return
	 */
	public Yacimiento findById(Long id);

	/**
	 * Guarda yacimiento
	 * 
	 * @param yacimiento
	 * @return
	 */
	public Yacimiento save(Yacimiento yacimiento);
		
	/**
	 * Elimina yacimiento
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Busca yacimiento por nombre
	 * 
	 * @param yacimiento
	 * @return
	 */
	Yacimiento findByNombre(String yacimiento);
	
}
