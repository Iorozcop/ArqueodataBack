package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import com.arqueodata.ArqueodataBack.models.entity.Campain;


public interface ICampainService {
	
    public List<Campain> findAll();
	
	public Campain findById(Long id);

	public Campain save(Campain campain);
	
	public void delete(Long id);

	Campain findByCampain(int campain);

}
