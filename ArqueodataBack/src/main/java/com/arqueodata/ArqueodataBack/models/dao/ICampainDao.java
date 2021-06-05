package com.arqueodata.ArqueodataBack.models.dao;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.arqueodata.ArqueodataBack.models.entity.Campain;


public interface ICampainDao extends JpaRepository<Campain, Long> {
	
	/**
	 * Busca por campaña
	 * 
	 * @param campain
	 * @return
	 */
	Campain findByCampain(int campain);

}
