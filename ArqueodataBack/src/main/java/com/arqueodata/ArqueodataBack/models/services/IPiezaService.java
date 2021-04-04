package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IPiezaService {

	public List<Pieza> findAll();
	
	public Pieza findById(Long id);

	public Pieza save(Pieza pieza);
	
	public void delete(Long id);
	
	public List<Yacimiento> findAllYacimientos();
	
	public List<Campain> findAllCampains();
	
}
