package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;


public interface IYacimientoDao extends CrudRepository<Yacimiento, Long> {

	Yacimiento findByNombre(String yacimiento);

	
}
