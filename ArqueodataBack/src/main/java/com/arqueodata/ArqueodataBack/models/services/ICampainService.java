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



public interface ICampainService {
	
	/**
	 * Muestra todos las campañas
	 * 
	 * @return
	 */
    public List<Campain> findAll();

    /**
     * Muestra todos las campañas con paginación
     * 
     * @param pageable
     * @return
     */
  	public Page<Campain> findAll(Pageable pageable);
	
  	/**
  	 * Muestra una campañas por id
  	 * 
  	 * @param id
  	 * @return
  	 */
	public Campain findById(Long id);

	/**
	 * Guarda campaña
	 * 
	 * @param campain
	 * @return
	 */
	public Campain save(Campain campain);

	/**
	 * Elimina campaña
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * Busca campaña por campaña
	 * 
	 * @param campain
	 * @return
	 */
	Campain findByCampain(int campain);

}
