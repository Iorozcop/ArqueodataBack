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

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IPiezaService {

	/**
	 * Encuentra todas las pizas
	 * 
	 * @return
	 */
	public List<Pieza> findAll();
	
	/**
	 * Encuentra todas las piezas con paginación
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Pieza> findAll(Pageable pageable);
	
	/**
	 * Encuentra pieza por id
	 * 
	 * @param id
	 * @return
	 */
	public Pieza findById(Long id);

	/**
	 * Guarda pieza
	 * 
	 * @param pieza
	 * @return
	 */
	public Pieza save(Pieza pieza);
	
	/**
	 * Elimina pieza
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Encuentra todos los yacimientos
	 * 
	 * @return
	 */
	public List<Yacimiento> findAllYacimientos();
	
	/**
	 * Encuentra todas las campañas
	 * 
	 * @return
	 */
	public List<Campain> findAllCampains();
	
	/**
	 * Busca piezas
	 * 
	 * @param pieza
	 * @return
	 */
	public List<Pieza> buscaPieza(Pieza pieza);

	
}
