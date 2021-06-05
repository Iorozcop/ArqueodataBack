package com.arqueodata.ArqueodataBack.models.dao;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IYacimientoDao extends JpaRepository<Yacimiento, Long> {
	
	/**
	 * Busca yacimiento por nombre
	 * 
	 * @param yacimiento
	 * @return
	 */
	Yacimiento findByNombre(String yacimiento);

}
