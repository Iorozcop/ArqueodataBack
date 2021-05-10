package com.arqueodata.ArqueodataBack.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IPiezaDao extends JpaRepository<Pieza, Long> {
	
	@Query("from Yacimiento")
	public List<Yacimiento> findAllYacimientos();
	
	@Query("from Campain")
	public List<Campain> findAllCampains();
	
}
