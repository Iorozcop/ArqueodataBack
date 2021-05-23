package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

public interface IYacimientoService {

	//muestra todos los yacimientos 
	public List<Yacimiento> findAll();
	
	//muestra todos los yacimientos con paginación
	public Page<Yacimiento> findAll(Pageable pageable);
	
	//busca yacimiento por id
	public Yacimiento findById(Long id);

	//guarda yacimiento
	public Yacimiento save(Yacimiento yacimiento);
		
	//elimina yacimiento
	public void delete(Long id);
	
	//busca yacimiento por nombre
	Yacimiento findByNombre(String yacimiento);
	
}
