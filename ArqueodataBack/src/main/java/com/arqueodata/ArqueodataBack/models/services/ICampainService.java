package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arqueodata.ArqueodataBack.models.entity.Campain;



public interface ICampainService {
	
	//muestra todos las campañas
    public List<Campain> findAll();
    
    //muestra todos las campañas con paginación
  	public Page<Campain> findAll(Pageable pageable);
	
  	//muestra una campañas por id
	public Campain findById(Long id);

	//guarda campaña
	public Campain save(Campain campain);
	
	//elimina campaña
	public void delete(Long id);

	//Busca campaña por campaña
	Campain findByCampain(int campain);

}
