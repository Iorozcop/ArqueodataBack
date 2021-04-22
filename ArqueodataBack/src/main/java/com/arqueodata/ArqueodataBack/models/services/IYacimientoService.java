package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IYacimientoService {

	public List<Yacimiento> findAll();
		
	public Yacimiento findById(Long id);

	public Yacimiento save(Yacimiento yacimiento);
		
	public void delete(Long id);
	
	Yacimiento findByNombre(String yacimiento);
	
}
