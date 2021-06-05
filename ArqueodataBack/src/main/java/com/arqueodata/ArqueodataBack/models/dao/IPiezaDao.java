package com.arqueodata.ArqueodataBack.models.dao;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IPiezaDao extends JpaRepository<Pieza, Long> {
	
	/**
	 * Trae todos los yacimientos
	 * 
	 * @return
	 */
	@Query("from Yacimiento")
	public List<Yacimiento> findAllYacimientos();
	
	
	/**
	 * Trae todas las campañas
	 * 
	 * @return
	 */
	@Query("from Campain")
	public List<Campain> findAllCampains();
	
}
