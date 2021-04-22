package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Campain;


public interface ICampainDao extends CrudRepository<Campain, Long> {

	Campain findByCampain(int campain);

}
