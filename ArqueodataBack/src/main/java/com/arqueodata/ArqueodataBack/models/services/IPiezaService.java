package com.arqueodata.ArqueodataBack.models.services;

//import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IPiezaService {

	public List<Pieza> findAll();
	
	public Page<Pieza> findAll(Pageable pageable);
	
	public Pieza findById(Long id);

	public Pieza save(Pieza pieza);
	
	public void delete(Long id);
	
	public List<Yacimiento> findAllYacimientos();
	
	public List<Campain> findAllCampains();
	
	public List<Pieza> buscaPieza(Pieza pieza);



	
	

	
	
	
}
